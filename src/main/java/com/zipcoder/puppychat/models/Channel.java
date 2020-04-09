package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Channel extends ChatSpace {

    private String name;

    @ManyToMany
    private Set<User> admins = new HashSet<>();;

    public Channel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Set<User> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<User> admins) {
        this.admins = admins;
    }

}
