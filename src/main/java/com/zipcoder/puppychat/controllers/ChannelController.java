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
@CrossOrigin
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
    public ResponseEntity<Channel> createChannel(@PathVariable int userId, @RequestBody String name) {
        return new ResponseEntity<>(service.create(userId, name), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/changeName/{id}")
    public ResponseEntity<Channel> updateChannelName(@PathVariable int id, @RequestBody String name) {
        return new ResponseEntity<Channel>(service.changeChannelName(id,name),HttpStatus.OK);
    }

    @PutMapping("/add/m/{id}/{channelId}")
    public ResponseEntity<Channel> addMember(@PathVariable int id, @PathVariable int channelId) {
        return new ResponseEntity<>(service.addMember(channelId,id),HttpStatus.OK);
    }

    @PutMapping("/add/a/{id}/{channelId}")
    public ResponseEntity<Channel> addAdmin(@PathVariable int id, @PathVariable int channelId) {
        return new ResponseEntity<>(service.addAdmin(channelId,id),HttpStatus.OK);
    }


    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Channel> deleteChannel(@PathVariable int id) {
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }

    @DeleteMapping("/m/{id}/{channelId}")
    public ResponseEntity<Channel> removeMember(@PathVariable int id, @PathVariable int channelId) {
        return new ResponseEntity<>(service.removeMember(channelId,id),HttpStatus.OK);
    }

    @DeleteMapping("/a/{id}/{channelId}")
    public ResponseEntity<Channel> removeAdmin(@PathVariable int id, @PathVariable int channelId) {
        return new ResponseEntity<>(service.removeAdmin(channelId,id),HttpStatus.OK);
    }
}