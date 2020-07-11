package iotpanel.CE.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @RequestMapping(value = {"","/"})
    public String index() {
        return "Greetings from Spring Boot sensor!";
    }

}
