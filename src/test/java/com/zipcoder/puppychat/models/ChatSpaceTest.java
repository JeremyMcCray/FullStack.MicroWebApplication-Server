package com.zipcoder.puppychat.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChatSpaceTest {



    @Test
    public void testMember(){
        List<User> memberList = new ArrayList<>();
        memberList.add(new User());
        memberList.add(new User());
        memberList.add(new User());

        ChatSpace cs = new DMSpace();
        cs.setMembers(memberList);

        Assert.assertEquals(memberList, cs.getMembers());
        Assert.assertEquals(3,cs.getMembers().size());
    }

    @Test
    public void testMessageList(){
        List<MainMessage> msg = new ArrayList<>();
        msg.add(new MainMessage());
        msg.add(new MainMessage());
        msg.add(new MainMessage());

        ChatSpace cs = new DMSpace();
        cs.setMessages(msg);

        Assert.assertEquals(msg, cs.getMessages());
    }
    }

