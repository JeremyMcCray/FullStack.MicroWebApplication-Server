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

@RunWith(MockitoJUnitRunner.class)
public class SocketControllerTest {
    @Mock
    MainMessageService service;

    @InjectMocks
    WebSocketController controller;

    @Test
    public void grabMsgTest() {

        Mockito.when(service.create(10,20,"Hello")).thenReturn(new MainMessage());
        Assert.assertTrue(controller.grabMsg(10,20,"Hello") instanceof MainMessage);
    }
}
