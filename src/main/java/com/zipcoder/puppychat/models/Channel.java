package com.zipcoder.puppychat.models;

import java.util.List;

public class Channel extends ChatSpace {

    private String name;
    private String topic;
    private List<User> admins;

    public Channel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }

}
