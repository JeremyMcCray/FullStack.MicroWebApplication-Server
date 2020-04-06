package com.zipcoder.puppychat.controllers;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.services.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emoji")
public class EmojiController {

    EmojiService service;

    @Autowired
    public EmojiController(EmojiService service){
        this.service = service;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Emoji> getEmoji(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public ResponseEntity<Emoji> createEmoji(@RequestBody Emoji emoji) {
        return new ResponseEntity<>(service.create(emoji), HttpStatus.OK);
    }


    @RequestMapping(value="/update/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Emoji> updateEmoji(@PathVariable int id, @RequestBody Emoji emoji) {
        return new ResponseEntity<>(service.update(id,emoji), HttpStatus.OK);
    }
}
