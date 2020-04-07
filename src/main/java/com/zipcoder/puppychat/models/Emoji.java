package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emoji {
    @Id
    int id;
    String name;
    String image;

    public Emoji(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
