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
    public UserController(UserService service){ this.service = service; }

    //=============== GET Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUser() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(service.update(id,user), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
