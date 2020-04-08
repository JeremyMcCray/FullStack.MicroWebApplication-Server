package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.services.DMSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dm")
public class DMSpaceController {
    DMSpaceService service;

    @Autowired
    public DMSpaceController(DMSpaceService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<DMSpace> getDMSpace(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<DMSpace>> getAllDMSpace() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<DMSpace> createDMSpace(@RequestBody DMSpace dmSpace) {
        return new ResponseEntity<>(service.create(dmSpace), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<DMSpace> updateDMSpace(@PathVariable int id, @RequestBody DMSpace dmSpace) {
        return new ResponseEntity<>(service.update(id,dmSpace), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteDMSpace(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
