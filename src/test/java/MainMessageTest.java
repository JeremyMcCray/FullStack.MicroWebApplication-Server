import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainMessageTest {

    MainMessage mainMessage = new MainMessage();
    Reply reply1 = new Reply();
    Reply reply2 = new Reply();
    Reply reply3 = new Reply();

    @Test
    public void MainMessageConstructorTest(){
        mainMessage.addMsg(reply1);
        Integer expected = 1;
        Integer actual = mainMessage.replies.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void AddMsgTest() {
        mainMessage.addMsg(reply1);
        mainMessage.addMsg(reply2);
        mainMessage.addMsg(reply3);
        Integer expected = 3;
        Integer actual = mainMessage.replies.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void RemoveMsg(){
        mainMessage.addMsg(reply1);
        mainMessage.addMsg(reply2);
        mainMessage.addMsg(reply3);
        mainMessage.removeMsg(reply2);
        Integer expected = 2;
        Integer actual = mainMessage.replies.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getReaction() {
        Message m1 = new MainMessage();
        String reactionName = "Happy";
        String reactionEmoji = ":)";
        m1.add(reactionName,reactionEmoji);
        Map<String, String> expected = m1.getReactions();
        Assert.assertTrue(expected.containsValue(reactionEmoji));
    }

    @Test
    public void setReaction() {
        Message m1 = new MainMessage();
        Map<String,String> myMap = new HashMap<>();
        String reactionName = "Happy";
        String reactionEmoji = ":)";
        myMap.put(reactionName,reactionEmoji);
        m1.setReactions(myMap);
        Assert.assertEquals(m1.getReactions(), myMap);
    }

    @Test
    public void addTest(){
        Message m1 = new MainMessage();
        String reactionName = "Happy";
        String reactionEmoji = ":)";
        m1.add(reactionName,reactionEmoji);
        Assert.assertTrue(m1.getReactions().containsValue(reactionEmoji));
    }

    @Test
    public void removeTest(){
        Message m1 = new MainMessage();
        String reactionName = "Happy";
        String reactionEmoji = ":)";
        m1.add(reactionName,reactionEmoji);
        Assert.assertTrue(m1.getReactions().containsValue(reactionEmoji));
        m1.remove(reactionName);
        Assert.assertFalse(m1.getReactions().containsValue(reactionEmoji));
    }

    @Test
    public void lookupTest(){
        Message m1 = new MainMessage();
        String expectedName = "Happy";
        String expectedEmoji = ":)";
        m1.add(expectedName,expectedEmoji);
        Assert.assertTrue(m1.getReactions().containsValue(expectedEmoji));
        String actualEmoji = m1.lookup(expectedName);
        Assert.assertEquals(expectedEmoji,actualEmoji);
    }

    @Test
    public void getSpeaker() {
        Message m1 = new MainMessage();
        User u1 = new User("John198","PassW0rd","john@email.com","John Wick" );
       m1.setSpeaker(u1);
        User expected = m1.getSpeaker();
        Assert.assertEquals(expected,u1);
    }

    @Test
    public void setSpeaker() {
        Message m1 = new MainMessage();
        User u1 = new User("John198","PassW0rd","john@email.com","John Wick" );
        m1.setSpeaker(u1);
        User expected = m1.getSpeaker();
        Assert.assertEquals(expected,u1);
    }

    @Test
    public void getContent() {
        Message m1 = new MainMessage();
        m1.setContent("Hello World");
        String expected = m1.getContent();
        Assert.assertEquals(expected,"Hello World");
    }

    @Test
    public void setContent() {
        Message m1 = new MainMessage();
        m1.setContent("Hello World");
        String expected = m1.getContent();
        Assert.assertEquals(expected,"Hello World");
    }


    @Test
    public void getTime() {
        Message m1 = new MainMessage();
        LocalDate d1 =  LocalDate.now();
        m1.setTimeStamp(d1);
        LocalDate expected = m1.getTimeStamp();
        Assert.assertEquals(expected, d1);
    }

    @Test
    public void setTime() {
        Message m1 = new MainMessage();
        LocalDate d1 =  LocalDate.now();
        m1.setTimeStamp(d1);
        LocalDate expected = m1.getTimeStamp();
        Assert.assertEquals(expected, d1);
    }

}

