package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MessageTest {
    @Test
    public void getReactions() {
        Message m1 = new MainMessage();
        String reactionName = "Happy";
        int reactionCount = 3;

        m1.getReactions().put(reactionName, reactionCount);
        Map<String, Integer> expected = m1.getReactions();

        Assert.assertEquals(1,expected.size());
        Assert.assertTrue(expected.containsKey(reactionName));
    }

    @Test
    public void setReaction() {
        Message m1 = new MainMessage();
        String reactionName = "Happy";
        int reactionCount = 3;

        Map<String, Integer> m = new HashMap<>();
        m.put(reactionName,reactionCount);

        m1.setReactions(m);
        Assert.assertEquals(m,m1.getReactions());
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
        LocalDate d1 =  LocalDate.now();
        m1.setTimeStamp(d1);
        LocalDate expected = m1.getTimeStamp();
        Assert.assertEquals(expected, d1);
    }
}
