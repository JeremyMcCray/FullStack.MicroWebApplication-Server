import java.util.ArrayList;

public class MainMessage extends Message {
    private ArrayList<Reply> replies;

    public MainMessage() {
        this.replies = new ArrayList<Reply>();
    }

    public void addMsg(Reply msg) {
        replies.add(msg);
    }

    public void removeMsg(Reply msg) {
        replies.remove(msg);
    }

}
