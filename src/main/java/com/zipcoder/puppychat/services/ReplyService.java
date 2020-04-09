package com.zipcoder.puppychat.services;
import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.MainMessageRepository;
import com.zipcoder.puppychat.repositories.ReplyRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyService {
    ReplyRepository repository;
    MainMessageRepository messageRepository;
    UserRepository userRepository;

    @Autowired
    public ReplyService(ReplyRepository repository,
                        MainMessageRepository messageRepository,
                        UserRepository userRepository){
        this.repository = repository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    };

    public Reply findById(int id){return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    //editReplyContent
    public Reply updateReplyContent(int replyId,String content){
        Reply r = findById(replyId);
        r.setContent(content);
        return repository.save(r);
    }


    public Reply create(int msgId, int userId, String content){
        Reply reply = new Reply();
        reply.setContent(content);
        MainMessage mm = messageRepository.findById(msgId).orElseThrow(NotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        reply.setSpeaker(user);
        reply.setRoot(mm);
        return repository.save(reply);
    }

    public void delete(int id){
        Reply reply = findById(id);
        repository.delete(reply);
    }

//    public Reply update(int id, Reply newInfo){
//        Optional<Reply> reply = repository.findById(id);
//        Reply existing = findById(id);
//        Util.copyNonNullProperties(newInfo, existing);
//        repository.save(existing);
//        return existing;
//    }
}
