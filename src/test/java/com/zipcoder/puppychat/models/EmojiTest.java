package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmojiTest {
    Emoji emoji = new Emoji();

    @Before
    public void setUp() {
        emoji.setName("puppy");
    }

    @Test
    public void get_an_set_EmojiName() {
        String name = "puppy";
        emoji.setName(name);
        String actual = emoji.getName();
        Assert.assertEquals("puppy", actual);
    }


    @Test
    public void getImage() {
    }

    @Test
    public void setImage() {
    }
}