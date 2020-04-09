package com.zipcoder.puppychat.models;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class ChatSpaceTest {

    ChatSpace c1 = new Channel();

    @Before
    public void setUp() {
       c1.setId(89);
    }

    @Test
    public void setId() {
        c1.setId(50);
        Assert.assertEquals(50,c1.getId());
    }

    @Test
    public void getId() { Assert.assertEquals(89,c1.getId()); }

    @Test
    public void testMember(){
        Set<User> memberList = new HashSet<>();
        memberList.add(new User());
        memberList.add(new User());
        memberList.add(new User());

        ChatSpace cs = new DMSpace();
        cs.setMembers(memberList);

        Assert.assertEquals(memberList, cs.getMembers());
        Assert.assertEquals(3,cs.getMembers().size());
    }


}
