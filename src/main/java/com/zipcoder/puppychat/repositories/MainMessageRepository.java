package com.zipcoder.puppychat.repositories;
import com.zipcoder.puppychat.models.MainMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainMessageRepository extends JpaRepository<MainMessage,Integer> {
}
