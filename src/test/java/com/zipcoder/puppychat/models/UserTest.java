package com.zipcoder.puppychat.models;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    User user = new User();

    @Before
    public void setUp(){
        user.setId(98);
        user.setPassword("PassW0rd");
        user.setEmail("john@email.com");
        user.setDisplayName("John Wick");
    }

    @Test
    public void getUserId() { Assert.assertEquals(98,user.getId()); }

    @Test
    public void getPassWord() {
        Assert.assertEquals("PassW0rd",user.getPassword());
    }

    @Test
    public void getEmail() {
        Assert.assertEquals("john@email.com",user.getEmail());
    }

    @Test
    public void getName() {
        Assert.assertEquals("John Wick",user.getDisplayName());
    }

    @Test
    public void setUserId() {
        user.setId(100);
        Assert.assertEquals(100,user.getId());
    }

    @Test
    public void setPassWord() {
        user.setPassword("Pa55word");
        Assert.assertEquals("Pa55word",user.getPassword());
    }

    @Test
    public void setEmail() {
        user.setEmail("james@gmail.com");
        Assert.assertEquals("james@gmail.com",user.getEmail());
    }

    @Test
    public void setName() {
        user.setDisplayName("James Bond");
        Assert.assertEquals("James Bond",user.getDisplayName());
    }

    @Test
    public void get_setUserName() {
        user.setUserName("Bond007");
        Assert.assertEquals("Bond007",user.getUserName());
    }

    @Test
    public void get_and_set_SubscribedChannels() {

        List<Channel> subscribedChannels = new ArrayList<>();
        subscribedChannels.add(new Channel());
        subscribedChannels.add(new Channel());

        User user = new User();
        user.setSubscribedChannels(subscribedChannels);
        Assert.assertEquals(subscribedChannels, user.getSubscribedChannels());
    }

    @Test
    public void get_and_set_ManagedChannels() {

        List<Channel> managedChannels = new ArrayList<>();
        managedChannels.add(new Channel());
        managedChannels.add(new Channel());

        User user = new User();
        user.setManagedChannels(managedChannels);
        Assert.assertEquals(managedChannels, user.getManagedChannels());
    }

}
