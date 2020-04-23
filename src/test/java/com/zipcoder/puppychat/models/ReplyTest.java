package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Test;

public class ReplyTest {
    @Test
    public void testRoot() {
        Reply r = new Reply();
        MainMessage mm = new MainMessage();
        String content = "this is a reply";
        r.setContent(content);
        r.setRoot(mm);

        Assert.assertEquals(r.getRoot(), mm);
        Assert.assertEquals(r.getContent(), content);
    }
}
