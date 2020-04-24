package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.DuplicateDataException;
import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.*;
import com.zipcoder.puppychat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MainMessageService {

    MainMessageRepository mainMessageRepository;
    UserRepository userRepository;
    ChannelRepository channelRepository;
    DMSpaceRepository dmSpaceRepository;
    EmojiRepository emojiRepository;
    ReplyRepository replyRepository;
    EmojiCountRepository emojiCountRepository;

//All on one line because this was getting really long\\\ vvv
    @Autowired
    public MainMessageService(
            MainMessageRepository mainMessageRepository,
            UserRepository userRepository,
            ChannelRepository channelRepository,
            DMSpaceRepository DMSpaceRepository,
            EmojiRepository emojiRepository,
            ReplyRepository replyRepository,
            EmojiCountRepository emojiCountRepository)
    {
        this.mainMessageRepository = mainMessageRepository;
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
        this.dmSpaceRepository = DMSpaceRepository;
        this.emojiRepository = emojiRepository;
        this.replyRepository = replyRepository;
        this.emojiCountRepository = emojiCountRepository;
    }

    public MainMessage findById(int id){
        return mainMessageRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    //find all by User
    public Iterable<MainMessage> findAllByUser(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return mainMessageRepository.findMainMessagesBySpeaker(u);
    }

    //find all by chat
    public Iterable<MainMessage> findAllByChat(int id){
        Optional<DMSpace> dm = dmSpaceRepository.findById(id);
        if(!dm.isPresent()){
            Channel ch = channelRepository.findById(id).orElseThrow(NotFoundException::new);
            return mainMessageRepository.findMainMessageByChatSpace(ch);
        }else{
            return mainMessageRepository.findMainMessageByChatSpace(dm.get());
        }
    }

    //list all replies to a message
    public Iterable<Reply> listAllReplies(int msgId){
        MainMessage message = findById(msgId);
        return replyRepository.findRepliesByRoot(message);
    }

    //editMessageContent
    public MainMessage updateMessageContent(int messageId,String newMessage){
        MainMessage message = findById(messageId);
        message.setContent(newMessage);
        return mainMessageRepository.save(message);
    }

    //react with emoji
    public MainMessage reactWithEmoji(int messageId, int emojiId){
        MainMessage message = findById(messageId);
        emojiRepository.findById(emojiId).orElseThrow(NotFoundException::new);

        for(EmojiCount ec : message.getEmojiCounts()){
            if(ec.getEmojiId()==emojiId)
                throw new DuplicateDataException();
        }
        EmojiCount newEc = new EmojiCount();
        newEc.setEmojiId(emojiId);
        newEc.setCount(1);
        emojiCountRepository.save(newEc);
        message.getEmojiCounts().add(newEc);
        return mainMessageRepository.save(message);
    }

    //add emoji count
    public MainMessage addEmojiCount(int messageId, int emojiId){
        MainMessage message = findById(messageId);
        emojiRepository.findById(emojiId).orElseThrow(NotFoundException::new);

        for(EmojiCount ec : message.getEmojiCounts()) {
            if (ec.getEmojiId() == emojiId) {
                ec.setCount(ec.getCount()+1);
                return mainMessageRepository.save(message);
            }
        }
        throw new NotFoundException();
    }

    public MainMessage create(int userId, int chatSpaceId, String content){
        User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        Optional<Channel> channel = channelRepository.findById(chatSpaceId);
        MainMessage mm = new MainMessage();
        if(!channel.isPresent()){
            DMSpace dm = dmSpaceRepository.findById(chatSpaceId).orElseThrow(NotFoundException::new);
            mm.setChatSpace(dm);
        }else{
            mm.setChatSpace(channel.get());
        }
        mm.setSpeaker(user);
        mm.setContent(content);
        mm.setTimeStamp(LocalDateTime.now());
        return mainMessageRepository.save(mm);
    }

    public MainMessage delete(int id){
        MainMessage mainMessage = findById(id);
        mainMessageRepository.delete(mainMessage);
        return mainMessage;
    }


    //find all by regex




//    public Iterable<MainMessage> findAllById(int id){
//        User u = UserRepository.
//        repository.findAllById(id);
//    }
//
//    public Iterable<MainMessage> findAll(){
//        return repository.findAll();
//    }
//    public MainMessage update(int id, MainMessage newInfo){
//        Optional<MainMessage> mainMessage = mainMessageRepository.findById(id);
//        MainMessage existing = findById(id);
//        Util.copyNonNullProperties(newInfo, existing);
//        mainMessageRepository.save(existing);
//        return existing;
//    }


}
