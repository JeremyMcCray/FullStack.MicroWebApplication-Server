package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        int reactionCount = 3;

        m1.getReactionsCount().put(e, reactionCount);
        Map<Emoji, Integer> expected = m1.getReactionsCount();

        Assert.assertEquals(1,expected.size());
        Assert.assertTrue(expected.containsKey(e));
    }

    @Test
    public void setReaction() {
        Message m1 = new MainMessage();
        Emoji e = new Emoji();
        int reactionCount = 3;

        Map<Emoji, Integer> m = new HashMap<>();
        m.put(e,reactionCount);

        m1.setReactionsCount(m);
        Assert.assertEquals(m,m1.getReactionsCount());
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
