package com.zipcoder.puppychat.repositories;

import com.zipcoder.puppychat.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Integer> {
}
