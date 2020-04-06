package com.zipcoder.puppychat.repositories;

import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Integer> {
    //derived query
    Iterable<Channel> findChannelsByAdmins(User user);
    Iterable<Channel> findChannelsByMembers(User user);

}
