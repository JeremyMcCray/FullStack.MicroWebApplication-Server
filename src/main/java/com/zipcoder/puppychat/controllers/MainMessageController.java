package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.services.MainMessageService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MainMessageController {
    MainMessageService service;

    public MainMessageController(MainMessageService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<MainMessage> getMsg(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<MainMessage>> getAllMsg() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<MainMessage> createMsg(@RequestBody MainMessage msg) {
        return new ResponseEntity<>(service.create(msg), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<MainMessage> updateMsg(@PathVariable int id, @RequestBody MainMessage msg) {
        return new ResponseEntity<>(service.update(id,msg), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMsg(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
