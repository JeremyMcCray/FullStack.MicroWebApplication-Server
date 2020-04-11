package com.zipcoder.puppychat.repositories;
import com.zipcoder.puppychat.models.ChatSpace;
import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMessageRepository extends JpaRepository<MainMessage,Integer> {

    Iterable<MainMessage> findMainMessagesBySpeaker(User user);
    Iterable<MainMessage> findMainMessageByChatSpace(ChatSpace chatSpace);

}
