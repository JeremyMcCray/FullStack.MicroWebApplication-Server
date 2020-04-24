package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.services.MainMessageService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
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


    @GetMapping("/allByChat/{id}")
    public ResponseEntity<Iterable<MainMessage>> getAllMessageByChat(@PathVariable int id){
        return new ResponseEntity<>(service.findAllByChat(id), HttpStatus.OK);
    }

    @GetMapping("/listAllReply/{id}")
    public ResponseEntity<Iterable<Reply>> listAllReplies(@PathVariable int id){
        return new ResponseEntity<>(service.listAllReplies(id), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/{userId}/{chatId}")
    public ResponseEntity<MainMessage> createMsg(@PathVariable int userId, @PathVariable int chatId,  @RequestBody String content) {
        return new ResponseEntity<>(service.create(userId, chatId, content), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/{id}")
    public ResponseEntity<MainMessage> updateMsgContent(@PathVariable int id, @RequestBody String content) {
        return new ResponseEntity<>(service.updateMessageContent(id,content), HttpStatus.OK);
    }

    @PutMapping("react/{msgId}/with/{emojiId}")
    public ResponseEntity<MainMessage> reactWithEmoji(@PathVariable int msgId, @PathVariable int emojiId) {
        return new ResponseEntity<>(service.reactWithEmoji(msgId,emojiId), HttpStatus.OK);
    }

    @PutMapping("add/{emojiId}/to/{msgId}")
    public ResponseEntity<MainMessage> addEmojiCount(@PathVariable int msgId, @PathVariable int emojiId) {
        return new ResponseEntity<>(service.addEmojiCount(msgId,emojiId), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteMsg(@PathVariable int id) {
        return new ResponseEntity<>(service.delete(id).getId(),HttpStatus.OK);
    }
}
