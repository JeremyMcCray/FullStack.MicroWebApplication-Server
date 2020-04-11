package com.zipcoder.puppychat.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@MappedSuperClass
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name="chat_abstract")
public abstract class ChatSpace {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private Set<User> members = new HashSet<>();

    public ChatSpace(){}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }


}

