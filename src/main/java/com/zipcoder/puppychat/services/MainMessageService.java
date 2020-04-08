package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.MainMessageRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainMessageService {

    MainMessageRepository repository;
    UserRepository userRepository;

    @Autowired
    public MainMessageService(MainMessageRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    };

    public MainMessage findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    //find all by User
    public Iterable<MainMessage> findAllByUser(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return repository.findMainMessagesBySpeaker(u);
    }

    // find all by Channel


    //find all by DM space


    //react with emoji


    //add emoji count



    //editMessageContent


    //find all by regex




//    public Iterable<MainMessage> findAllById(int id){
//        User u = UserRepository.
//        repository.findAllById(id);
//    }
//
//    public Iterable<MainMessage> findAll(){
//        return repository.findAll();
//    }

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
