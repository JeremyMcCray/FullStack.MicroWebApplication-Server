package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.Emoji;
import com.zipcoder.puppychat.repositories.EmojiRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class EmojiServiceTest {

    @Mock
    EmojiRepository emojiRepo;

    @InjectMocks
    EmojiService emojiSer;

    @Test
    public void findById() {
        int id = 1;
        Emoji e = new Emoji();
        e.setId(id);
        Mockito.when(emojiRepo.findById(id)).thenReturn(Optional.of(e));
        Assert.assertEquals(e, emojiSer.findById(id));
    }

    @Test
    public void findAll() {
        Emoji emoji1 = new Emoji();
        Emoji emoji2 = new Emoji();
        List<Emoji> list = new ArrayList<>();
        list.add(emoji1);
        list.add(emoji2);
        Mockito.when(emojiRepo.findAll()).thenReturn(list);
        Assert.assertEquals(list, emojiSer.findAll());
    }

    @Test
    public void create() {
        Emoji e = new Emoji();
        Mockito.when(emojiRepo.save(any())).thenReturn(e);
        Assert.assertEquals(e, emojiSer.create(e));
    }

    @Test
    public void update() {
        Emoji e = new Emoji();
        e.setId(1);
        e.setName("sad_frog");
        e.setImage("sad_frog.png");

        Emoji updatedEmoji = new Emoji();
        e.setName("depressed_frog");
        e.setImage("depressed_frog.png");

        Mockito.when(emojiRepo.findById(1)).thenReturn(Optional.of(e));
        Mockito.when(emojiRepo.save(any())).thenReturn(e);

        Emoji actual = emojiSer.update(1, updatedEmoji);
        Assert.assertEquals("depressed_frog", actual.getName());
        Assert.assertEquals("depressed_frog.png", actual.getImage());
    }

    @Test
    public void delete() {
        int emojiId = 2;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);
        Mockito.when(emojiRepo.findById(emojiId)).thenReturn(Optional.of(emoji));

        Assert.assertEquals(emoji, emojiSer.delete(emojiId));
    }
}
