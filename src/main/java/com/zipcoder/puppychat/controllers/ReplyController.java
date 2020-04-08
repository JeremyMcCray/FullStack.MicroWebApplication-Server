package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.services.ReplyService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    ReplyService service;

    public ReplyController(ReplyService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Reply> getReply(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Reply>> getAllReply() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
        return new ResponseEntity<>(service.create(reply), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Reply> updateReply(@PathVariable int id, @RequestBody Reply reply) {
        return new ResponseEntity<>(service.update(id,reply), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReply(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
