package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.services.DMSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/dm")
public class DMSpaceController {
    DMSpaceService service;

    @Autowired
    public DMSpaceController(DMSpaceService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @GetMapping("/{id}")
    public ResponseEntity<DMSpace> getDMSpace(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/allByUser/{userId}")
    public ResponseEntity<Iterable<DMSpace>> getAllDMSpaceByUser(@PathVariable int userId) {
        return new ResponseEntity<>(service.findAllByAMember(userId), HttpStatus.OK);
    }

    @GetMapping("/allMember/{id}")
    public ResponseEntity<Iterable<User>> listAllMembers(@PathVariable int id) {
        return new ResponseEntity<>(service.listAllMembers(id), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/{userId}/{targetUserId}")
    public ResponseEntity<DMSpace> createDMSpace(@PathVariable int userId, @PathVariable int targetUserId) {
        return new ResponseEntity<>(service.create(userId,targetUserId), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("add/{userId}/to/{dmSpaceId}")
    public ResponseEntity<DMSpace> addMemberToDMSpace(@PathVariable int dmSpaceId, @PathVariable int userId) {
        return new ResponseEntity<>(service.addMember(dmSpaceId,userId),HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<DMSpace> deleteDMSpace(@PathVariable int id) {
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

}
