import java.util.List;

public abstract class ChatSpace {

    List<User> members;
    List<MainMessage> message;

    public ChatSpace() {}

    public class User {
    }

    public class MainMessage {
    }

    public ChatSpace(List<User> members, List<MainMessage> message) {
        this.members = members;
        this.message = message;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<MainMessage> getMessage() {
        return message;
    }

    public void setMessage(List<MainMessage> message) {
        this.message = message;
    }
}

