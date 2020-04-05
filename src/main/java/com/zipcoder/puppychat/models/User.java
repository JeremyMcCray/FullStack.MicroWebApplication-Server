package com.zipcoder.puppychat.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private String password;
    private String email;
    private String userName;
    private String displayName;

    @ManyToMany
    private List<Channel> subscribedChannels;

    @ManyToMany(mappedBy = "admins")
    private List<Channel> managedChannels;

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
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

    public void setDisplayName(String name) {
        this.displayName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
