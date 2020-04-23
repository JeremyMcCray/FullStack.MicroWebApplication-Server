package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.services.ReplyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

@RunWith(MockitoJUnitRunner.class)
public class ReplyControllerTest {

    @Mock
    ReplyService service;

    @InjectMocks
    ReplyController controller;

    @Test
    public void getReply() {
        Mockito.when(service.findById(1)).thenReturn(new Reply());
        Assert.assertEquals(HttpStatus.OK, controller.getReply(1).getStatusCode());
    }

    @Test
    public void createReply() {
        Mockito.when(service.create(10, 20, "Hello")).thenReturn(new Reply());
        Assert.assertEquals(HttpStatus.OK, controller.createReply(10, 20, "Hello").getStatusCode());
    }

    @Test
    public void updateReplyContent() {
        Mockito.when(service.updateReplyContent(10, "Hello")).thenReturn(new Reply());
        Assert.assertEquals(HttpStatus.OK, controller.updateReplyContent(10, "Hello").getStatusCode());
    }

    @Test
    public void deleteReply() {
        Mockito.when(service.delete(10)).thenReturn(new Reply());
        Assert.assertEquals(HttpStatus.OK, controller.deleteReply(10).getStatusCode());
    }
}
