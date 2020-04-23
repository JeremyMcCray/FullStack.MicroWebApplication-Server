package com.zipcoder.puppychat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class MainMessage extends Message {

    @OneToMany
    private List<Reply> replies;

    @JsonIgnore
    @ManyToOne
    private ChatSpace chatSpace;

    public MainMessage() {
        this.replies = new ArrayList<Reply>();
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public ChatSpace getChatSpace() {
        return chatSpace;
    }

    public void setChatSpace(ChatSpace chatSpace) {
        this.chatSpace = chatSpace;
    }
}
