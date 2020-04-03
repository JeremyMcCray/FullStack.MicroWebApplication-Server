package com.zipcoder.puppychat.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class MainMessage extends Message {

    @OneToMany
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
