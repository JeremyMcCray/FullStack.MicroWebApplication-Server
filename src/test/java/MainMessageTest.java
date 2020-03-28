import org.junit.Assert;
import org.junit.Test;

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
}
