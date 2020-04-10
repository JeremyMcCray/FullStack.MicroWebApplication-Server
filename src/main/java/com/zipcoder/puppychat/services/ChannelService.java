package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.ChannelRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

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

    public Channel create(int userId, String channelName){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        Channel newChannel = new Channel();
        newChannel.setAdmins(new HashSet<>());
        newChannel.setMembers(new HashSet<>());
        newChannel.setName(channelName);
        newChannel.getAdmins().add(u);// add self
        newChannel.getMembers().add(u);// add self
        return repository.save(newChannel);
    }

    //change channel name
    public Channel changeChannelName(int channelId, String newName){
        Channel existing = findById(channelId);
        existing.setName(newName);
        return repository.save(existing);
    }

    //add new member to channel
    public Channel addMember(int channelId, int userId){
        Channel existing = findById(channelId);
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        existing.getMembers().add(u);
        return repository.save(existing);
    }

    //add new admin to channel
    public Channel addAdmin(int channelId, int userId){
        Channel existing = findById(channelId);
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        existing.getAdmins().add(u);
        return repository.save(existing);
    }

    //remove a member from channel
    public Channel removeMember(int channelId, int userId){
        Channel existing = findById(channelId);
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        existing.getMembers().remove(u);
        return repository.save(existing);
    }

    //remove a admin from channel
    public Channel removeAdmin(int channelId, int userId){
        Channel existing = findById(channelId);
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        existing.getAdmins().remove(u);
        return repository.save(existing);
    }

    //get all admin
    public Iterable<User> listAllAdmins(int channelId){
        Channel existing = findById(channelId);
        return existing.getAdmins();
    }

    //get all members
    public Iterable<User> listAllMembers(int channelId){
        Channel existing = findById(channelId);
        return existing.getMembers();
    }

    public Channel delete(int id){
        Channel channel = findById(id);
        repository.delete(channel);
        return channel;
    }

}
