package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Emoji;
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

        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<MainMessage> findAll(){
        return repository.findAll();
    }

    public MainMessage create(MainMessage channel){
        return repository.save(channel);
    }

    public MainMessage update(int id, MainMessage newInfo){
        Optional<MainMessage> mainMessage = repository.findById(id);
        MainMessage existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        repository.save(existing);
        return existing;
    }

    public void delete(int id){
        MainMessage mainMessage = findById(id);
        repository.delete(mainMessage);
    }
}
