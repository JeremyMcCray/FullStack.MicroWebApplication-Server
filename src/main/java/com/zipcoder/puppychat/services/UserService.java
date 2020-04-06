package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public User update(int id, User info){
        Optional<User> user = repository.findById(id);
        return user.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<User> user = repository.findById(id);
        return user.map( u -> {
            repository.delete(u);
            return true;
        }).orElse(false);
    }
}
