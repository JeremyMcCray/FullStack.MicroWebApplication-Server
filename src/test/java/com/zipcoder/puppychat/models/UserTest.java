package com.zipcoder.puppychat.models;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user = new User();

    @Before
    public void setUp(){
        user.setId(98);
        user.setPassWord("PassW0rd");
        user.setEmail("john@email.com");
        user.setDisplayName("John Wick");
    }

    @Test
    public void getUserId() { Assert.assertEquals("John198",user.getId()); }

    @Test
    public void getPassWord() {
        Assert.assertEquals("PassW0rd",user.getPassWord());
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
        user.setPassWord("Pa55word");
        Assert.assertEquals("Pa55word",user.getPassWord());
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
}
