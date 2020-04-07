package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.repositories.MainMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainMessageService {

    MainMessageRepository repository;

    @Autowired
    public MainMessageService(MainMessageRepository repository){
        this.repository = repository;
    };

    public MainMessage findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Iterable<MainMessage> findAll(){
        return repository.findAll();
    }

    public MainMessage create(MainMessage channel){
        return repository.save(channel);
    }

    public MainMessage update(int id, MainMessage info){
        Optional<MainMessage> mainMessage = repository.findById(id);
        return mainMessage.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<MainMessage> mainMessage = repository.findById(id);
        return mainMessage.map( mm -> {
            repository.delete(mm);
            return true;
        }).orElse(false);
    }
}
