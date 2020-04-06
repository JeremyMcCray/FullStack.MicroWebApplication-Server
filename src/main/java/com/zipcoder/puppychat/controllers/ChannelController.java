package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/channel")
public class ChannelController {
    ChannelService service;

    @Autowired
    public ChannelController(ChannelService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Channel> getChannel(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Channel>> getAllChannel() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return new ResponseEntity<>(service.create(channel), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Channel> updateChannel(@PathVariable int id, @RequestBody Channel channel) {
        return new ResponseEntity<>(service.update(id,channel), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChannel(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
