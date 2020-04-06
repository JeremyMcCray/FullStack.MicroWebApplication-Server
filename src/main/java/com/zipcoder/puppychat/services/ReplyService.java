package com.zipcoder.puppychat.services;
import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.repositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReplyService {
    ReplyRepository repository;

    @Autowired
    public ReplyService(ReplyRepository repository){
        this.repository = repository;
    };

    public Reply findById(int id){return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Reply> findAll(){
        return repository.findAll();
    }

    public Reply create(Reply reply){
        return repository.save(reply);
    }

    public Reply update(int id, Reply newInfo){
        Optional<Reply> reply = repository.findById(id);
        Reply existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        repository.save(existing);
        return existing;
    }

    public void delete(int id){
        Reply reply = findById(id);
        repository.delete(reply);
    }
}
