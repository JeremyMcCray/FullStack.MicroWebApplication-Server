package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.repositories.DMSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DMSpaceService {

    DMSpaceRepository repository;

    @Autowired
    public DMSpaceService(DMSpaceRepository repository){
        this.repository = repository;
    }

    public DMSpace findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Iterable<DMSpace> findAll(){
        return repository.findAll();
    }

    public DMSpace create(DMSpace space){
        return repository.save(space);
    }

    public DMSpace update(int id, DMSpace info){
        Optional<DMSpace> dmSpace = repository.findById(id);
        return dmSpace.map(department -> {
            info.setId(id);
            repository.save(info);
            return info;
        }).orElse(null);
    }

    public boolean delete(int id){
        Optional<DMSpace> dmSpace = repository.findById(id);
        return dmSpace.map( ds -> {
            repository.delete(ds);
            return true;
        }).orElse(false);
    }
}
