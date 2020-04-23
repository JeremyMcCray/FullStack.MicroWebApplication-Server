package com.zipcoder.puppychat.controllers;


import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.services.MainMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketController {

    MainMessageService mainMessageService;

    @Autowired
    public WebSocketController(MainMessageService mainMessageService) {
        this.mainMessageService = mainMessageService;
    }

    //when some user talked in front-end(eg. press send)
    //front end will send the info to where ever @MessageMapping specified
    //the message will then get broadcast by @SendTo
    @MessageMapping("/send/msg/{userId}/{chatId}")
    @SendTo("/pool/{chatId}")
    public MainMessage grabMsg(@DestinationVariable int userId, @DestinationVariable int chatId, String content){
        //store the upcoming msg to dm
        //return the message the the center
        return mainMessageService.create(userId, chatId, content);
    }



}
