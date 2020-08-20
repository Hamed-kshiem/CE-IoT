package iotpanel.CE.controller;

import iotpanel.CE.model.Sensor;
import iotpanel.CE.model.User;
import iotpanel.CE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserRepository test ;

    @RequestMapping("/")
    public String index () {
  return "sa";
    }



}
