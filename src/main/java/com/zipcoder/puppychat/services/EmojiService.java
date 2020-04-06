package com.zipcoder.puppychat.services;
import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.repositories.EmojiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmojiService {

    EmojiRepository repository;

    @Autowired
    public EmojiService(EmojiRepository repository){
        this.repository = repository;
    };

    public Emoji findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Emoji> findAll(){
        return repository.findAll();
    }

    public Emoji create(Emoji emoji){
        return repository.save(emoji);
    }

    public Emoji update(int id, Emoji info){
        Optional<Emoji> emoji = repository.findById(id);
        return emoji.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<Emoji> emoji = repository.findById(id);
        return emoji.map( em -> {
            repository.delete(em);
            return true;
        }).orElse(false);
    }
}
