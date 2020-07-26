/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.controller;

import iotpanel.CE.model.User;
import iotpanel.CE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository user;

    @RequestMapping(value = {"", "/"})
    public List<iotpanel.CE.model.User> getall() {
        return user.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity addSensor(@RequestBody User UserBody) {
        System.out.println(UserBody.toString());
        user.save(UserBody);
        return new ResponseEntity("Hello World!", HttpStatus.OK);
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
        }).orElseGet(()->{
            newUser.setId(id);
           return user.save(newUser);
        });
    }
}
