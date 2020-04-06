package com.zipcoder.puppychat.controllers;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    UserService service;

    @Autowired
    public UserController(UserService service){}

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<User> getVote(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


}
