package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChannelTest {


    @Test
    public void get_and_set_ChannelName() {
        // Given
        Channel channel = new Channel();

        // When
        String nameTag = "coolChannel";
        channel.setName(  nameTag  );
        String actual = channel.getName();

        // Then
        Assert.assertEquals( "coolChannel"  , actual  );
    }

    @Test
    public void get_and_set_Admins() {

        List<User> admin = new ArrayList<>();
        admin.add(new User());
        admin.add(new User());

        // Given
        Channel channel = new Channel();

        // When
        channel.setAdmins(admin);

        // Then
        Assert.assertEquals(admin, channel.getAdmins());
    }

    @Test
    public void get_and_set_Topic() {
        Channel c = new Channel();
        c.setTopic("we chat here!!!!!!");
        Assert.assertEquals( "we chat here!!!!!!" , c.getTopic()  );
    }


}