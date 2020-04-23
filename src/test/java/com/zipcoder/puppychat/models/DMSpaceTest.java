package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

public class DMSpaceTest {
    @Test
    public void testInheritance() {
        DMSpace ds = new DMSpace();
        Assert.assertTrue(ds instanceof ChatSpace);
    }
}
