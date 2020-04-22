package com.zipcoder.puppychat.models;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name="message_abstract")
public abstract class Message {
    @Id
    @GeneratedValue
    private int id;

    //@createdBy?
    @ManyToOne
    private User speaker;
    private String content;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime timeStamp;

    @ElementCollection
    @CollectionTable(name = "reaction_mapping",
            joinColumns = {@JoinColumn(name = "message_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "emoji_name")
    @Column
    private Map<Emoji, Integer> reactionsCount;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Message() {
        this.reactionsCount = new HashMap<>();
    }

    public Map<Emoji, Integer> getReactionsCount() {
        return reactionsCount;
    }

    public void setReactionsCount(Map<Emoji, Integer> reactions) {
        this.reactionsCount = reactions;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

}
