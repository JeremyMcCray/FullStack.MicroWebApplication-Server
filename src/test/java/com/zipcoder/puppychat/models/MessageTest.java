package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageTest {

    @Test
    public void get_setId() {
        Message m1 = new MainMessage();
        m1.setId(50);
        Assert.assertEquals(50,m1.getId());
    }

    @Test
    public void getReactions() {
        Message m1 = new MainMessage();
        Emoji e = new Emoji();
        e.setId(1);
        int reactionCount = 3;
        EmojiCount ec = new EmojiCount();
        ec.setEmojiId(1);
        ec.setCount(reactionCount);

        m1.getEmojiCounts().add(ec);
        List<EmojiCount> expected = m1.getEmojiCounts();

        Assert.assertEquals(1,expected.size());
        Assert.assertTrue(expected.contains(ec));
    }

    @Test
    public void setReaction() {
        Message m1 = new MainMessage();
        Emoji e = new Emoji();
        e.setId(1);
        int reactionCount = 3;
        EmojiCount ec = new EmojiCount();
        ec.setEmojiId(1);
        ec.setCount(reactionCount);

        m1.getEmojiCounts().add(ec);
        List<EmojiCount> expected = m1.getEmojiCounts();

        m1.setEmojiCounts(expected);
        Assert.assertEquals(expected,m1.getEmojiCounts());
    }


    @Test
    public void get_and_Set_Speaker() {
        Message m1 = new MainMessage();
        User u1 = new User();
        m1.setSpeaker(u1);
        User expected = m1.getSpeaker();
        Assert.assertEquals(expected,u1);
    }

    @Test
    public void get_and_set_Content() {
        Message m1 = new MainMessage();
        m1.setContent("Hello World");
        String expected = m1.getContent();
        Assert.assertEquals(expected,"Hello World");
    }


    @Test
    public void get_and_set_Time() {
        Message m1 = new MainMessage();
        LocalDateTime d1 =  LocalDateTime.now();
        m1.setTimeStamp(d1);
        LocalDateTime expected = m1.getTimeStamp();
        Assert.assertEquals(expected, d1);
    }
}
