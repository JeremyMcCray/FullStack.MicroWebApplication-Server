package models;

import java.util.ArrayList;
import java.util.List;

public class MainMessage extends Message {

    private List<Reply> replies;

    public MainMessage() {
        this.replies = new ArrayList<Reply>();
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

}
