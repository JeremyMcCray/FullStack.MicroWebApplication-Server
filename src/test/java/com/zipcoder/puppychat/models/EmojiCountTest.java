package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

public class EmojiCountTest {
    @Test
    public void id_get_and_set_Test(){
        EmojiCount ec = new EmojiCount();
        ec.setId(1);
        Assert.assertEquals(1,ec.getId());
    }

    @Test
    public void emojiId_get_and_set_Test(){
        EmojiCount ec = new EmojiCount();
        ec.setEmojiId(1);
        Assert.assertEquals(1,ec.getEmojiId());
    }

    @Test
    public void count_get_and_set_Test(){
        EmojiCount ec = new EmojiCount();
        ec.setCount(999);
        Assert.assertEquals(999,ec.getCount());
    }

}
