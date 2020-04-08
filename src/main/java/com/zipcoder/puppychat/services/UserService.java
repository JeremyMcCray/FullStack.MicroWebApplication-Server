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

    public User update(int id, User newInfo){
        User existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        repository.save(existing);
        return existing;
    }

    public void delete(int id){
        User user = findById(id);
        repository.delete(user);
    }
}
