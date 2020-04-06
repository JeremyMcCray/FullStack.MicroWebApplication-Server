package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Channel extends ChatSpace {

    private String name;

    @ManyToMany
    private List<User> admins = new ArrayList<>();;

    public Channel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }

}
