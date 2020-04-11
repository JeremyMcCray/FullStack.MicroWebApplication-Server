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
    @GetMapping("/{id}")
    public ResponseEntity<Reply> getReply(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/on/{msgId}/by/{userId}")
    public ResponseEntity<Reply> createReply(@PathVariable int msgId,
                                             @PathVariable int userId,
                                             @RequestBody String content) {
        return new ResponseEntity<>(service.create(msgId,userId,content), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/{id}")
    public ResponseEntity<Reply> updateReplyContent(@PathVariable int id, @RequestBody String content) {
        return new ResponseEntity<>(service.updateReplyContent(id,content), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
