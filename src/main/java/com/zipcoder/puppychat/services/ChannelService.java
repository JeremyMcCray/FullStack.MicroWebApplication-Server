package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.Channel;
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
        return repository.findById(id).orElse(null);
    }

    public Iterable<Channel> findAll(){
        return repository.findAll();
    }

    public Channel create(Channel channel){
        return repository.save(channel);
    }

    public Channel update(int id, Channel info){
        Optional<Channel> channel = repository.findById(id);
        return channel.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<Channel> channel = repository.findById(id);
        return channel.map( ch -> {
            repository.delete(ch);
            return true;
        }).orElse(false);
    }

}
