package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.models.Emoji;
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
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Iterable<DMSpace> findAll(){
        return repository.findAll();
    }

    public DMSpace create(DMSpace space){
        return repository.save(space);
    }

    public DMSpace update(int id, DMSpace newInfo){
        Optional<DMSpace> DMSpace = repository.findById(id);
        DMSpace existing = findById(id);
        Util.copyNonNullProperties(newInfo, existing);
        repository.save(existing);
        return existing;
    }

    public void delete(int id){
        DMSpace DMSpace = findById(id);
        repository.delete(DMSpace);
    }
}
