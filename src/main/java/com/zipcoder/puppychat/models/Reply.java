package com.zipcoder.puppychat.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reply extends Message {
    @ManyToOne
    private MainMessage root;

    public MainMessage getRoot() {
        return root;
    }

    public void setRoot(MainMessage root) {
        this.root = root;
    }

}
