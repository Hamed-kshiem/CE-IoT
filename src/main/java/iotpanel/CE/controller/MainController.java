package iotpanel.CE.controller;

import iotpanel.CE.model.User;
import iotpanel.CE.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserRepository test ;

    @RequestMapping("/")
    public String index () {
  return "banner.txt";
    }


}
