package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChannelTest {

    Channel c = new Channel();
    List<User> admin = new ArrayList<>();
    String chatName = "chat";
    String chatTopic = "just chat here!";

    @Before
    public void setUp(){
        admin.add(new User());
        admin.add(new User());

        c.setName(chatName);
        c.setTopic(chatTopic);
        c.setAdmins(admin);
    }

    @Test
    public void getChannelName() {
        Assert.assertEquals(chatName, c.getName() );
    }

    @Test
    public void getAdmins() {
        Assert.assertEquals(admin, c.getAdmins());
    }

    @Test
    public void get_and_set_Topic() {
        Assert.assertEquals( chatTopic, c.getTopic()  );
    }


}