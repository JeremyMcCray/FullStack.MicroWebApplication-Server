package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    };

    public User findById(int id){
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<User> findAll(){
        return repository.findAll();
    }

    public User create(User user){
        return repository.save(user);
    }

    public User changePassword(int userId, String newPassword){
        User u = findById(userId);
        u.setPassword(newPassword);
        return repository.save(u);
    }

    public User changeEmail(int userId, String newEmail){
        User u = findById(userId);
        u.setEmail(newEmail);
        return repository.save(u);
    }

    public User changeDisplayName(int userId, String newDisplayName){
        User u = findById(userId);
        u.setDisplayName(newDisplayName);
        return repository.save(u);
    }

    public User delete(int id){
        User user = findById(id);
        repository.delete(user);
        return user;
    }
}
