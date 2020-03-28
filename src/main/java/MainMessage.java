import java.util.List;

public class MainMessage extends Message {
    List<Reply> replies;

    public MainMessage() {
    }

    public MainMessage(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
