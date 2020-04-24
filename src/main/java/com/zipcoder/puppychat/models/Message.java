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

//    @ElementCollection
//    @CollectionTable(name = "reaction_mapping",
//            joinColumns = {@JoinColumn(name = "message_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "emoji_id")
//    @Column
//    private Map<Integer, Integer> reactionsCount;

    @OneToMany
    private List<EmojiCount> emojiCounts;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Message() {
        this.emojiCounts = new ArrayList<>();
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

    public List<EmojiCount> getEmojiCounts() {
        return emojiCounts;
    }

    public void setEmojiCounts(List<EmojiCount> emojiCounts) {
        this.emojiCounts = emojiCounts;
    }
}
