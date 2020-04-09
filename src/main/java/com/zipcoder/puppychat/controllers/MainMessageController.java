package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.services.MainMessageService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/msg")
public class MainMessageController {
    MainMessageService service;

    public MainMessageController(MainMessageService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @GetMapping("/{id}")
    public ResponseEntity<MainMessage> getMsg(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/allByUser/{id}")
    public ResponseEntity<Iterable<MainMessage>> getAllMessageByUser(@PathVariable int id){
        return new ResponseEntity<>(service.findAllByUser(id), HttpStatus.OK);
    }

    @GetMapping("/allByChannel/{id}")
    public ResponseEntity<Iterable<MainMessage>> getAllMessageByChannel(@PathVariable int id){
        return new ResponseEntity<>(service.findAllByChannel(id), HttpStatus.OK);
    }

    @GetMapping("/allByDm/{id}")
    public ResponseEntity<Iterable<MainMessage>> getAllMessageByDM(@PathVariable int id){
        return new ResponseEntity<>(service.findAllByDM(id), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/create")
    public ResponseEntity<MainMessage> createMsg(@RequestBody MainMessage msg) {
        return new ResponseEntity<>(service.create(msg), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
//    @PutMapping("/{id}")
//    public ResponseEntity<MainMessage> updateMsg(@PathVariable int id, @RequestBody MainMessage msg) {
//        return new ResponseEntity<>(service.update(id,msg), HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<MainMessage> updateMsgContent(@PathVariable int id, @RequestBody String msg) {
        return new ResponseEntity<>(service.updateMessage(id,msg), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMsg(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
