package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.services.EmojiService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class EmojiControllerTest {

    @Mock
    EmojiService service;

    @InjectMocks
    EmojiController controller;

    @Test
    public void getEmoji() {
        Mockito.when(service.findById(30)).thenReturn(new Emoji());
        Assert.assertEquals(HttpStatus.OK, controller.getEmoji(30).getStatusCode());
    }

    @Test
    public void getAllEmoji() {
        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());
        Assert.assertEquals(HttpStatus.OK, controller.getAllEmoji().getStatusCode());
    }

    @Test
    public void createEmoji() {
        Emoji e = new Emoji();
        Mockito.when(service.create(e)).thenReturn(e);
        Assert.assertEquals(HttpStatus.OK, controller.createEmoji(e).getStatusCode());
    }

    @Test
    public void updateEmoji() {
        Emoji e = new Emoji();
        Mockito.when(service.update(12, e)).thenReturn(e);
        Assert.assertEquals(HttpStatus.OK, controller.updateEmoji(12, e).getStatusCode());
    }

    @Test
    public void deleteEmoji() {
        Mockito.when(service.delete(100)).thenReturn(new Emoji());
        Assert.assertEquals(HttpStatus.OK, controller.deleteEmoji(100).getStatusCode());

    }
}
