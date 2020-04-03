package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

public class ReplyTest {
    @Test
    public void testInheritance(){
        Reply rep = new Reply();
        Assert.assertTrue(rep instanceof Message);
    }
}
