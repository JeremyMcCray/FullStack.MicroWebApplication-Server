package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.ChannelRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChannelService {
    ChannelRepository repository;
    UserRepository userRepository;

    @Autowired
    public ChannelService(ChannelRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    };

    public Channel findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<Channel> findAllByAnAdmin(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return repository.findChannelsByAdmins(u);
    }

    public Iterable<Channel> findAllByAMember(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return repository.findChannelsByMembers(u);
    }

    public Channel create(Channel newChannel, int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        newChannel.getAdmins().add(u);
        newChannel.getMembers().add(u);
        return repository.save(newChannel);
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
