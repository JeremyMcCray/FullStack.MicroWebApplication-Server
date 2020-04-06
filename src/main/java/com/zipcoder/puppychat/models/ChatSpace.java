package com.zipcoder.puppychat.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name="chat_abstract")
public abstract class ChatSpace {

    @Id
    private int id;

    @ManyToMany
    private List<User> members;

    public ChatSpace(){}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }


}

