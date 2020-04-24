package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.error.DuplicateDataException;
import com.zipcoder.puppychat.error.NotFoundException;
import com.zipcoder.puppychat.models.*;
import com.zipcoder.puppychat.repositories.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MainMessageServiceTest {

    @Mock
    MainMessageRepository mainMessageRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    ChannelRepository channelRepository;
    @Mock
    DMSpaceRepository dmSpaceRepository;
    @Mock
    EmojiRepository emojiRepository;
    @Mock
    ReplyRepository replyRepository;
    @Mock
    EmojiCountRepository emojiCountRepository;

    @InjectMocks
    MainMessageService mainMessageService;

    @Test
    public void findById() {
        int msgId = 100;
        MainMessage mm = new MainMessage();
        mm.setId(msgId);
        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(mm));
        Assert.assertEquals(mm,mainMessageService.findById(msgId));
    }

    @Test
    public void findAllByUser() {
        MainMessage msg = new MainMessage();
        List<MainMessage> list = new ArrayList<>();
        list.add(msg);

        int userId = 1;
        User user = new User();
        user.setId(userId);

        Mockito.when(mainMessageRepository.findMainMessagesBySpeaker(user)).thenReturn(list);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Assert.assertEquals(list,mainMessageService.findAllByUser(userId));
    }

    @Test
    public void findAllByChatId() {
        MainMessage msg = new MainMessage();
        List<MainMessage> list = new ArrayList<>();
        list.add(msg);

        int channelId = 1;
        Channel channel = new Channel();
        channel.setId(channelId);

        Mockito.when(mainMessageRepository.findMainMessageByChatSpace(channel)).thenReturn(list);
        Mockito.when(channelRepository.findById(channelId)).thenReturn(Optional.of(channel));
        Assert.assertEquals(list,mainMessageService.findAllByChat(channelId));
    }


    @Test
    public void findAllByChatId_dm() {
        MainMessage msg = new MainMessage();
        List<MainMessage> list = new ArrayList<>();
        list.add(msg);

        int dmlId = 1;
        DMSpace dm = new DMSpace();
        dm.setId(dmlId);

        Mockito.when(mainMessageRepository.findMainMessageByChatSpace(dm)).thenReturn(list);
        Mockito.when(dmSpaceRepository.findById(dmlId)).thenReturn(Optional.of(dm));
        Assert.assertEquals(list,mainMessageService.findAllByChat(dmlId));
    }


    @Test
    public void listAllReplies() {
        int msgId = 30;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        List<Reply> replies = new ArrayList<>();
        replies.add(new Reply());

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(replyRepository.findRepliesByRoot(msg)).thenReturn(replies);

        Assert.assertEquals(replies, mainMessageService.listAllReplies(msgId));
    }

    @Test
    public void updateMessageContent() {
        int msgId = 50;
        String oldContent = "before";
        String newContent = "after";
        MainMessage msg = new MainMessage();
        msg.setId(msgId);
        msg.setContent(oldContent);

        MainMessage updatedMsg = new MainMessage();
        msg.setId(msgId);
        msg.setContent(newContent);

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(updatedMsg);
        Assert.assertEquals( updatedMsg ,mainMessageService.updateMessageContent(msgId,newContent));
    }

    @Test
    public void reactWithEmoji_regularCase() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId)).thenReturn(Optional.of(emoji));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(msg);
        Assert.assertEquals(msg ,mainMessageService.reactWithEmoji(msgId,emojiId));
    }

    @Test
    public void reactWithEmoji_regularCase2() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);
        EmojiCount ec = new EmojiCount();
        ec.setCount(5);
        ec.setEmojiId(emojiId);
        msg.getEmojiCounts().add(ec);

        int emojiId2 = 2;
        Emoji emoji2 = new Emoji();
        emoji2.setId(emojiId2);
        EmojiCount ec2 = new EmojiCount();
        ec2.setCount(2);
        ec2.setEmojiId(emojiId2);

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId2)).thenReturn(Optional.of(emoji2));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(msg);
        Assert.assertEquals(msg ,mainMessageService.reactWithEmoji(msgId,emojiId2));
    }

    @Test(expected = DuplicateDataException.class)
    public void reactWithEmoji_FailCase() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);

        EmojiCount ec = new EmojiCount();
        ec.setCount(5);
        ec.setEmojiId(emojiId);
        msg.getEmojiCounts().add(ec);

//        msg.setReactionsCount(new HashMap<>());
//        msg.getReactionsCount().put(emoji.getId(),5);
//
        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId)).thenReturn(Optional.of(emoji));
        mainMessageService.reactWithEmoji(msgId,emojiId);
    }

    @Test
    public void addEmojiCount_regularCase2() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);
        EmojiCount ec = new EmojiCount();
        ec.setCount(5);
        ec.setEmojiId(emojiId);
        msg.getEmojiCounts().add(ec);

        int emojiId2 = 2;
        Emoji emoji2 = new Emoji();
        emoji2.setId(emojiId2);
        EmojiCount ec2 = new EmojiCount();
        ec2.setCount(2);
        ec2.setEmojiId(emojiId2);
        msg.getEmojiCounts().add(ec2);

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId2)).thenReturn(Optional.of(emoji2));
        mainMessageService.addEmojiCount(msgId,emojiId2);
    }

    @Test
    public void addEmojiCount_regularCase() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);
        EmojiCount ec = new EmojiCount();
        ec.setCount(5);
        ec.setEmojiId(emojiId);
        msg.getEmojiCounts().add(ec);

        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId)).thenReturn(Optional.of(emoji));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(msg);
        Assert.assertEquals(msg ,mainMessageService.addEmojiCount(msgId,emojiId));
    }


    @Test(expected = NotFoundException.class)
    public void addEmojiCount_failCase() {
        int msgId = 10;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);
        int emojiId = 1;
        Emoji emoji = new Emoji();
        emoji.setId(emojiId);
        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(emojiRepository.findById(emojiId)).thenReturn(Optional.of(emoji));
        mainMessageService.addEmojiCount(msgId,emojiId);
    }



    @Test
    public void create_in_channel() {
        int msgId = 1;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int userId = 10;
        User user = new User();
        user.setId(userId);

        int chatId = 100;
        Channel channel = new Channel();
        channel.setId(chatId);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(channelRepository.findById(chatId)).thenReturn(Optional.of(channel));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(msg);

        Assert.assertEquals( msg ,mainMessageService.create(userId,chatId,"hello!"));
    }


    @Test
    public void create_in_dm() {
        int msgId = 1;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int userId = 10;
        User user = new User();
        user.setId(userId);

        int dmId = 200;
        DMSpace dm = new DMSpace();
        dm.setId(dmId);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(dmSpaceRepository.findById(dmId)).thenReturn(Optional.of(dm));
        Mockito.when(mainMessageRepository.save(any())).thenReturn(msg);

        Assert.assertEquals( msg ,mainMessageService.create(userId,dmId,"hello!!!!!!!"));
    }

    @Test
    public void delete() {
        int msgId = 5;
        MainMessage mainMessage = new MainMessage();
        mainMessage.setId(msgId);
        Mockito.when(mainMessageRepository.findById(msgId)).thenReturn(Optional.of(mainMessage));

        Assert.assertEquals(mainMessage,mainMessageService.delete(msgId));
    }
}