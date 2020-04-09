package com.zipcoder.puppychat.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class User{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String password;
    private String email;
    private String displayName;

    @JsonIgnore
    @ManyToMany
    private List<Channel> subscribedChannels;

    @JsonIgnore
    @ManyToMany(mappedBy = "admins")
    private List<Channel> managedChannels;

    public User(){ }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Channel> getSubscribedChannels() {
        return subscribedChannels;
    }

    public void setSubscribedChannels(List<Channel> subscribedChannels) {
        this.subscribedChannels = subscribedChannels;
    }

    public List<Channel> getManagedChannels() {
        return managedChannels;
    }

    public void setManagedChannels(List<Channel> managedChannels) {
        this.managedChannels = managedChannels;
    }
}
