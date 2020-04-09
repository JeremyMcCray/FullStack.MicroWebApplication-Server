package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/channel")
public class ChannelController {
    ChannelService service;

    @Autowired
    public ChannelController(ChannelService service){
        this.service = service;
    }

    //=============== GET Mappings ===============//
    @GetMapping("/{id}")
    public ResponseEntity<Channel> getChannel(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all/a/{userId}")
    public ResponseEntity<Iterable<Channel>> getAllManagedChannels(@PathVariable int userId) {
        return new ResponseEntity<>(service.findAllByAnAdmin(userId), HttpStatus.OK);
    }

    @GetMapping("/all/m/{userId}")
    public ResponseEntity<Iterable<Channel>> getAllSubscribedChannel(@PathVariable int userId) {
        return new ResponseEntity<>(service.findAllByAMember(userId), HttpStatus.OK);
    }

    @GetMapping("/showAllAdmins/{channelId}")
    public ResponseEntity<Iterable<User>> getAllAdminsByChannel(@PathVariable int channelId) {
        return new ResponseEntity<>(service.listAllAdmins(channelId), HttpStatus.OK);
    }

    @GetMapping("/showAllMembers/{channelId}")
    public ResponseEntity<Iterable<User>> getAllMembersByChannel(@PathVariable int channelId) {
        return new ResponseEntity<>(service.listAllMembers(channelId), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/{userId}")
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel, @PathVariable int userId) {
        return new ResponseEntity<>(service.create(channel,userId), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/changeName/{id}")
    public ResponseEntity<Void> updateChannelName(@PathVariable int id, @RequestBody String name) {
        service.changeChannelName(id,name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/add/m/{id}/{channelId}")
    public ResponseEntity<Void> addMember(@PathVariable int id, @PathVariable int channelId) {
        service.addMember(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/add/a/{id}/{channelId}")
    public ResponseEntity<Void> addAdmin(@PathVariable int id, @PathVariable int channelId) {
        service.addAdmin(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/m/{id}/{channelId}")
    public ResponseEntity<Void> removeMember(@PathVariable int id, @PathVariable int channelId) {
        service.removeMember(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/a/{id}/{channelId}")
    public ResponseEntity<Void> removeAdmin(@PathVariable int id, @PathVariable int channelId) {
        service.removeAdmin(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
