package models;

import java.util.List;

public abstract class ChatSpace {

    private List<User> members;
    private List<MainMessage> messages;

    public ChatSpace(){}

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<MainMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<MainMessage> message) {
        this.messages = message;
    }
}

