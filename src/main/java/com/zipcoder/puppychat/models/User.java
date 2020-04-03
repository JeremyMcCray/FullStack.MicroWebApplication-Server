package com.zipcoder.puppychat.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private String id;
    private String password;
    private String email;
    private String name;

    @ManyToMany
    private List<Channel> subscribedChannels;

    @ManyToMany(mappedBy = "admins")
    private List<Channel> managedChannels;

    public User() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
