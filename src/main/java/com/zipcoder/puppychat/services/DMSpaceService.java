package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.DMSpaceRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DMSpaceService {

    DMSpaceRepository repository;
    UserRepository userRepository;

    @Autowired
    public DMSpaceService(DMSpaceRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public DMSpace findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<DMSpace> findAllByAMember(int userId){
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        return repository.findDMSpacesByMembers(u);
    }

    public DMSpace create(int userId, int targetUserId) {
        User u1 = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        User u2 = userRepository.findById(targetUserId).orElseThrow(NotFoundException::new);
        DMSpace newSpace = new DMSpace();
        newSpace.setMembers(new HashSet<>());
        newSpace.getMembers().add(u1);// add self
        newSpace.getMembers().add(u2);
        return repository.save(newSpace);
    }

    //add new member to space
    public void addMember(int spaceId, int userId){
        DMSpace existing = findById(spaceId);
        User u = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        existing.getMembers().add(u);
        repository.save(existing);
    }

    //get all members
    public Iterable<User> listAllMembers(int spaceId){
        DMSpace existing = findById(spaceId);
        return existing.getMembers();
    }

    public void delete(int id){
        DMSpace DMSpace = findById(id);
        repository.delete(DMSpace);
    }
}
