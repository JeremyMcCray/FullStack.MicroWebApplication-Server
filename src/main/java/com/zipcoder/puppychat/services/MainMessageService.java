package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.*;
import com.zipcoder.puppychat.repositories.ChannelRepository;
import com.zipcoder.puppychat.repositories.DMSpaceRepository;
import com.zipcoder.puppychat.repositories.MainMessageRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainMessageService {

    MainMessageRepository mainMessageRepository;
    UserRepository userRepository;
    ChannelRepository channelRepository;
    DMSpaceRepository dmSpaceRepository;
//All on one line because this was getting really long\\\ vvv
    @Autowired
    public MainMessageService(
            MainMessageRepository mainMessageRepository,
            UserRepository userRepository,
            ChannelRepository channelRepository,
            DMSpaceRepository DMspace)
    {
        this.mainMessageRepository = mainMessageRepository;
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
        this.dmSpaceRepository = DMspace;
    }

    public MainMessage findById(int id){
        return mainMessageRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    //find all by User
    public Iterable<MainMessage> findAllByUser(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return mainMessageRepository.findMainMessagesBySpeaker(u);
    }

    // find all by Channel
    public Iterable<MainMessage> findAllByChannel(int channelId){
        Channel chat = channelRepository.findById(channelId).orElseThrow(NotFoundException::new);
        return mainMessageRepository.findMainMessageByChatSpace(chat);
    }
    /// ^^^ these 2 use the same quiry so maybe it wont work? vvv
    //find all by DM space
    public Iterable<MainMessage> findAllByDM(int dmSpaceID){
        DMSpace chat = dmSpaceRepository.findById(dmSpaceID).orElseThrow(NotFoundException::new);
        return mainMessageRepository.findMainMessageByChatSpace(chat);
    }

    //editMessageContent
    public void updateMessage(int messageId,String newMessage){
        MainMessage message = mainMessageRepository.findById(messageId).orElseThrow(NotFoundException::new);
        message.setContent(newMessage);
        mainMessageRepository.save(message);
    }

    //react with emoji


    //add emoji count





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
        return mainMessageRepository.save(channel);
    }

    public MainMessage update(int id, MainMessage newInfo){
        Optional<MainMessage> mainMessage = mainMessageRepository.findById(id);
        MainMessage existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        mainMessageRepository.save(existing);
        return existing;
    }

    public void delete(int id){
        MainMessage mainMessage = findById(id);
        mainMessageRepository.delete(mainMessage);
    }
}
