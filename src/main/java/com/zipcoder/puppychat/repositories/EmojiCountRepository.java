package com.zipcoder.puppychat.repositories;

import com.zipcoder.puppychat.models.EmojiCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiCountRepository extends JpaRepository<EmojiCount,Integer> {
}
