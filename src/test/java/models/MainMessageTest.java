package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainMessageTest {

    @Test
    public void get_and_set_replyTest(){
        List<Reply> rep = new ArrayList<>();
        rep.add(new Reply());
        rep.add(new Reply());
        rep.add(new Reply());

        MainMessage mm = new MainMessage();
        mm.setReplies(rep);

        Assert.assertEquals(rep, mm.getReplies());
    }


}

