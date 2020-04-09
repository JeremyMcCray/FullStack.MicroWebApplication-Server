package com.zipcoder.puppychat.repositories;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMSpaceRepository extends JpaRepository<DMSpace,Integer> {
    Iterable<DMSpace> findDMSpacesByMembers(User user);
}
