package com.zipcoder.puppychat.models;

import java.time.LocalDate;
import java.util.*;

public abstract class Message {
    private User speaker;
    private String content;
    private LocalDate timeStamp;
    private Map<String, Integer> reactions;

    public Message() {
        this.reactions = new HashMap<>();
    }

    public Map<String, Integer> getReactions() {
        return reactions;
    }

    public void setReactions(Map<String, Integer> reactions) {
        this.reactions = reactions;
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

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

}
