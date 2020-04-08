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

    //=============== GET Mappings ===============//
    @GetMapping("/{id}")
    public ResponseEntity<Emoji> getEmoji(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Emoji>> getAllEmoji() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //=============== POST Mappings ===============//
    @PostMapping("/create")
    public ResponseEntity<Emoji> createEmoji(@RequestBody Emoji emoji) {
        return new ResponseEntity<>(service.create(emoji), HttpStatus.OK);
    }

    //=============== PUT Mappings ===============//
    @PutMapping("/update/{id}")
    public ResponseEntity<Emoji> updateEmoji(@PathVariable int id, @RequestBody Emoji emoji) {
        return new ResponseEntity<>(service.update(id,emoji), HttpStatus.OK);
    }

    //=============== DELETE Mappings ===============//
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmoji(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
