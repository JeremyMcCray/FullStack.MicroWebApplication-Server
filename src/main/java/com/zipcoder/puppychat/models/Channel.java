package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "channel")
public class Channel extends ChatSpace {

    private String name;
    private String topic;

    @ManyToMany
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
