package iotpanel.CE.controller;

import iotpanel.CE.Security.Services.MyUserDetailsService;
import iotpanel.CE.Security.models.AuthenticationRequest;
import iotpanel.CE.Security.models.AuthenticationResponse;
import iotpanel.CE.Security.util.JwtUtil;
import iotpanel.CE.email.EmailService;
import iotpanel.CE.model.LastLogin;
import iotpanel.CE.model.RFID;
import iotpanel.CE.model.User;
import iotpanel.CE.repositories.LastLoginREspository;
import iotpanel.CE.repositories.RFIDRepository;
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
import java.text.Collator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    RFIDRepository RFID;
    @Autowired
    UserRepository user;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/singup")
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

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
       User responceuser= user.findByUsername(authenticationRequest.getUsername());

        final User userDetails = user.findByEmail(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println("** "+responceuser);

        responceuser.setJwt(jwt);
        EmailService mailSender = new EmailService();
        mailSender.sendMessage("Admin@facebook.com","username","hi how are you from server ");
        return ResponseEntity.ok(responceuser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findUserByFingerprint(@PathVariable("id") String id) {
        if(user.findByFingerprint(id)== null){
            return new ResponseEntity<String>("Not found!", HttpStatus.BAD_REQUEST);

        }
        User userlogin = user.findByFingerprint(id);
        RFID.save(new RFID(userlogin.getId(),userlogin.getFirstname(),new Date()));
        return new ResponseEntity<String>("user found ",HttpStatus.OK);

    }
    @GetMapping("/loginlist")
    public Iterable<RFID> getLastRFIDLogins(){
        RFID.findAll().forEach(s-> System.out.println(s));
        return RFID.findAll();
    }
}
