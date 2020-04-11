package com.zipcoder.puppychat.repositories;
import com.zipcoder.puppychat.models.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiRepository extends JpaRepository<Emoji,Integer> {
}
