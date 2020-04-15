package com.zipcoder.puppychat.controllers;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service){ this.service = service; }

    //=============== GET Mappings ===============//
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> getAllUser() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/password/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable int id, @RequestBody String password) {
        return new ResponseEntity<>(service.changePassword(id,password), HttpStatus.OK);
    }

    @PutMapping("/email/{id}")
    public ResponseEntity<User> updateEmail(@PathVariable int id, @RequestBody String email) {
        return new ResponseEntity<>(service.changeEmail(id,email), HttpStatus.OK);
    }

    @PutMapping("/displayName/{id}")
    public ResponseEntity<User> updateDisplayName(@PathVariable int id, @RequestBody String displayName) {
        return new ResponseEntity<>(service.changeDisplayName(id,displayName), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
