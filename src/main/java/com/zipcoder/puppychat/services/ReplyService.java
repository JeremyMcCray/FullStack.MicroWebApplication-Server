package com.zipcoder.puppychat.services;
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

    public Reply findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Iterable<Reply> findAll(){
        return repository.findAll();
    }

    public Reply create(Reply reply){
        return repository.save(reply);
    }

    public Reply update(int id, Reply info){
        Optional<Reply> reply = repository.findById(id);
        return reply.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<Reply> reply = repository.findById(id);
        return reply.map( re -> {
            repository.delete(re);
            return true;
        }).orElse(false);
    }
}
