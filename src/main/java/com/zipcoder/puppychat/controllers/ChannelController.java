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
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Channel> getChannel(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/all/a/{userId}", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Channel>> getAllManagedChannels(@PathVariable int userId) {
        return new ResponseEntity<>(service.findAllByAnAdmin(userId), HttpStatus.OK);
    }

    @RequestMapping(value="/all/m/{userId}", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Channel>> getAllSubscribedChannel(@PathVariable int userId) {
        return new ResponseEntity<>(service.findAllByAMember(userId), HttpStatus.OK);
    }

    @RequestMapping(value="/showAllAdmins/{channelId}", method= RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllAdminsByChannel(@PathVariable int channelId) {
        return new ResponseEntity<>(service.listAllAdmins(channelId), HttpStatus.OK);
    }

    @RequestMapping(value="/showAllMembers/{channelId}", method= RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllMembersByChannel(@PathVariable int channelId) {
        return new ResponseEntity<>(service.listAllMembers(channelId), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @RequestMapping(value="/create/{userId}", method= RequestMethod.POST)
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel, @PathVariable int userId) {
        return new ResponseEntity<>(service.create(channel,userId), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @RequestMapping(value="/{id}/{newName}", method= RequestMethod.PUT)
    public ResponseEntity<Void> updateChannelName(@PathVariable int id, @PathVariable String newName) {
        service.changeChannelName(id,newName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/add/m/{id}/{channelId}", method= RequestMethod.PUT)
    public ResponseEntity<Void> addMember(@PathVariable int id, @PathVariable int channelId) {
        service.addMember(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/add/a/{id}/{channelId}", method= RequestMethod.PUT)
    public ResponseEntity<Void> addAdmin(@PathVariable int id, @PathVariable int channelId) {
        service.addAdmin(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //=============== DELETE Mappings ===============//
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deleteChannel(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/m/{id}/{channelId}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> removeMember(@PathVariable int id, @PathVariable int channelId) {
        service.removeMember(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/a/{id}/{channelId}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> removeAdmin(@PathVariable int id, @PathVariable int channelId) {
        service.removeAdmin(channelId,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
