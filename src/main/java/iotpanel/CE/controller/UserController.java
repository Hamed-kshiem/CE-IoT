/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.controller;

import iotpanel.CE.Security.Services.MyUserDetailsService;
import iotpanel.CE.Security.models.AuthenticationRequest;
import iotpanel.CE.Security.models.AuthenticationResponse;
import iotpanel.CE.Security.util.JwtUtil;
import iotpanel.CE.model.User;
import iotpanel.CE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository user;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping(value = {"", "/"})
    public List<iotpanel.CE.model.User> getall() {
        return user.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity addSensor(@RequestBody User UserBody, HttpServletRequest request) {
        System.out.println(UserBody.toString());
        user.save(UserBody);
        Map<String, Object> newUser = new HashMap<String, Object>();
        newUser.put("User", UserBody);
        newUser.put("status", HttpStatus.OK);
        newUser.put("TimeStamp", new Date());
        newUser.put("Data",request.getLocalAddr());
        return new ResponseEntity(newUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<User> findUserByID(@PathVariable("id") Integer id) {
        return user.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserByID(@PathVariable("id") Integer id) {
        user.deleteById(id);
        return new ResponseEntity("User was Deleted!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User newUser) {
        return user.findById(id).map(newUserObj -> {
            newUserObj.setFirstname(newUser.getFirstname());
            newUserObj.setLastname(newUser.getLastname());
            newUserObj.setPassword(newUser.getPassword());
            newUserObj.setUsername(newUser.getUsername());
            return user.save(newUserObj);
        }).orElseGet(() -> {
            newUser.setId(id);
            return user.save(newUser);
        });
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
