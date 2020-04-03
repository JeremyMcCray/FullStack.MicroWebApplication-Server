package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emoji {
    @Id
    String name;
    String image;

    public Emoji(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
