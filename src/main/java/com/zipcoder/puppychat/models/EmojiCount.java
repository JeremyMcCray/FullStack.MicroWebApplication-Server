package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmojiCount {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private int emojiId;
    private int count;

    public EmojiCount() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmojiId() {
        return emojiId;
    }

    public void setEmojiId(int emojiId) {
        this.emojiId = emojiId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
