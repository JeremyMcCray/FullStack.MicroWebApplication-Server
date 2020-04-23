package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmojiTest {
    Emoji emoji = new Emoji();

    @Before
    public void setUp() {
        emoji.setId(1);
        emoji.setName("Happy");
        emoji.setImage(":)");
    }

    @Test
    public void getId() {
        Assert.assertEquals(1, emoji.getId());
    }

    @Test
    public void setId() {
        emoji.setId(99);
        Assert.assertEquals(99, emoji.getId());
    }

    @Test
    public void getName() {
        Assert.assertEquals("Happy", emoji.getName());
    }

    @Test
    public void setName() {
        emoji.setName("Sad");
        Assert.assertEquals("Sad", emoji.getName());
    }

    @Test
    public void getImage() {
        Assert.assertEquals(":)", emoji.getImage());
    }

    @Test
    public void setImage() {
        emoji.setName(":(");
        Assert.assertEquals(":(", emoji.getName());
    }
}
