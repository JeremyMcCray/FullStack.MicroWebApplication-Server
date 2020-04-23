package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.MainMessage;
import com.zipcoder.puppychat.models.Reply;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.MainMessageRepository;
import com.zipcoder.puppychat.repositories.ReplyRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ReplyServiceTest {
    @Mock
    ReplyRepository replyRepository;
    @Mock
    MainMessageRepository messageRepository;
    @Mock
    UserRepository userRepository;

    @InjectMocks
    ReplyService replyService;

    @Test
    public void findById() {
        int replyId = 100;
        Reply reply = new Reply();
        reply.setId(replyId);

        Mockito.when(replyRepository.findById(replyId)).thenReturn(Optional.of(reply));
        Assert.assertEquals(reply, replyService.findById(replyId));
    }

    @Test
    public void updateReplyContent() {
        int replyId = 15;
        String oldContent = "before";
        String newContent = "after";
        Reply reply = new Reply();
        reply.setId(replyId);
        reply.setContent(oldContent);

        Reply updateReply = new Reply();
        updateReply.setId(replyId);
        updateReply.setContent(newContent);

        Mockito.when(replyRepository.findById(replyId)).thenReturn(Optional.of(reply));
        Mockito.when(replyRepository.save(any())).thenReturn(updateReply);
        Assert.assertEquals(updateReply, replyService.updateReplyContent(replyId, newContent));
    }

    @Test
    public void create() {
        int replyId = 1;
        Reply reply = new Reply();
        reply.setId(replyId);

        int msgId = 5;
        MainMessage msg = new MainMessage();
        msg.setId(msgId);

        int userId = 10;
        User user = new User();
        user.setId(userId);

        Mockito.when(messageRepository.findById(msgId)).thenReturn(Optional.of(msg));
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(replyRepository.save(any())).thenReturn(reply);

        Assert.assertEquals(reply, replyService.create(msgId, userId, "some reply"));

    }

    @Test
    public void delete() {
        int replyId = 5;
        Reply reply = new Reply();
        reply.setId(replyId);
        Mockito.when(replyRepository.findById(replyId)).thenReturn(Optional.of(reply));
        Assert.assertEquals(reply, replyService.delete(replyId));
    }
}
