package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.services.MainMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainMessageControllerTest {

    @Mock
    MainMessageService service;

    @InjectMocks
    MainMessageController controller;

    @Test
    public void getMsg() {
        Mockito.when(service.findById(10)).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK, controller.getMsg(10).getStatusCode());
    }

    @Test
    public void getAllMessageByUser() {
        Mockito.when(service.findAllByUser(10)).thenReturn(new ArrayList<>());
        Assert.assertEquals(HttpStatus.OK, controller.getAllMessageByUser(10).getStatusCode());
    }

    @Test
    public void getAllMessageByChat() {
        Mockito.when(service.findAllByChat(10)).thenReturn(new ArrayList<>());
        Assert.assertEquals(HttpStatus.OK, controller.getAllMessageByChat(10).getStatusCode());
    }

    @Test
    public void listAllReplies() {
        Mockito.when(service.listAllReplies(10)).thenReturn(new ArrayList<>());
        Assert.assertEquals(HttpStatus.OK,controller.listAllReplies(10).getStatusCode());
    }

    @Test
    public void createMsg() {
        Mockito.when(service.create(10,20,"Hello")).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK, controller.createMsg(10,20,"Hello").getStatusCode());
    }

    @Test
    public void updateMsgContent() {
        Mockito.when(service.updateMessageContent(10,"hello")).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK,controller.updateMsgContent(10,"hello").getStatusCode());
    }

    @Test
    public void reactWithEmoji() {
        Mockito.when(service.reactWithEmoji(10,10)).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK,controller.reactWithEmoji(10,10).getStatusCode());
    }

    @Test
    public void addEmojiCount() {
        Mockito.when(service.addEmojiCount(10,10)).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK, controller.addEmojiCount(10,10).getStatusCode());
    }

    @Test
    public void deleteMsg() {
        Mockito.when(service.delete(10)).thenReturn(new MainMessage());
        Assert.assertEquals(HttpStatus.OK, controller.deleteMsg(10).getStatusCode());
    }
}
