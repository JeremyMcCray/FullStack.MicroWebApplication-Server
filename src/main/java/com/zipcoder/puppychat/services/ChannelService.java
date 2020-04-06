package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChannelService {
    ChannelRepository repository;

    @Autowired
    public ChannelService(ChannelRepository repository){
        this.repository = repository;
    };

    public Channel findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Channel> findAll(){
        return repository.findAll();
    }

    public Channel create(Channel channel){
        return repository.save(channel);
    }

    public Channel update(int id, Channel newInfo){
        Optional<Channel> channel = repository.findById(id);
        Channel existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        repository.save(existing);
        return existing;
    }

    public void delete(int id){
        Channel channel = findById(id);
        repository.delete(channel);
    }

}
