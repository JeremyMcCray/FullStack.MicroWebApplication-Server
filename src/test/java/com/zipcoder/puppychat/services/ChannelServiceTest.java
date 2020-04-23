package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.ChannelRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ChannelServiceTest {

    @Mock
    ChannelRepository chRepo;

    @Mock
    UserRepository userRepo;

    @InjectMocks
    ChannelService chService;


    @Test
    public void findById() {
        int channelId = 10;
        Channel channel = new Channel();
        channel.setId(channelId);
        Mockito.when(chRepo.findById(channelId)).thenReturn(Optional.of(channel));
        Assert.assertEquals(channel, chService.findById(channelId));
    }

    @Test
    public void findAllByAnAdmin() {
        Channel space1 = new Channel();
        Set<Channel> set = new HashSet<>();
        set.add(space1);
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setManagedChannels(set);

        Mockito.when(chRepo.findChannelsByAdmins(user)).thenReturn(set);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Assert.assertEquals(user.getManagedChannels(), chService.findAllByAnAdmin(userId));
    }

    @Test
    public void findAllByAMember() {
        Channel space1 = new Channel();
        Set<Channel> set = new HashSet<>();
        set.add(space1);
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setSubscribedChannels(set);

        Mockito.when(chRepo.findChannelsByMembers(user)).thenReturn(set);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Assert.assertEquals(user.getSubscribedChannels(), chService.findAllByAMember(userId));
    }

    @Test
    public void create() {
        int userId = 1;
        User user = new User();
        user.setId(userId);
        String channelName = "chat";
        Channel ch = new Channel();
        ch.setName(channelName);

        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(chRepo.save(any())).thenReturn(ch);
        Assert.assertEquals(ch, chService.create(userId, channelName));
    }

    @Test
    public void changeChannelName() {
        Channel ch = new Channel();
        int channelId = 10;
        ch.setId(channelId);
        String oldName = "Big Dog";
        ch.setName(oldName);
        Mockito.when(chRepo.findById(channelId)).thenReturn(Optional.of(ch));
        Mockito.when(chRepo.save(any())).thenReturn(ch);
        String newName = "We <3 Samoyed!!";

        String actualName = chService.changeChannelName(channelId, newName).getName();
        Assert.assertEquals(newName, actualName);
        Assert.assertNotEquals(oldName, actualName);
    }

    @Test
    public void addMember() {
        int chId = 10;
        Channel ch = new Channel();
        ch.setId(chId);

        int userId = 1;
        User user = new User();
        user.setId(userId);

        Channel updatedChannel = new Channel();
        updatedChannel.setId(chId);
        updatedChannel.setMembers(new HashSet<>());
        updatedChannel.getMembers().add(user);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(chRepo.findById(chId)).thenReturn(Optional.of(ch));
        Mockito.when(chRepo.save(any())).thenReturn(updatedChannel);

        Assert.assertEquals(updatedChannel, chService.addMember(chId, userId));
    }

    @Test
    public void addAdmin() {
        int chId = 10;
        Channel ch = new Channel();
        ch.setId(chId);

        int userId = 1;
        User user = new User();
        user.setId(userId);

        Channel updatedChannel = new Channel();
        updatedChannel.setId(chId);
        updatedChannel.setAdmins(new HashSet<>());
        updatedChannel.getAdmins().add(user);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(chRepo.findById(chId)).thenReturn(Optional.of(ch));
        Mockito.when(chRepo.save(any())).thenReturn(updatedChannel);

        Assert.assertEquals(updatedChannel, chService.addAdmin(chId, userId));
    }

    @Test
    public void removeMember() {
        int userId = 1;
        User user = new User();
        user.setId(userId);

        int userId2 = 2;
        User user2 = new User();
        user2.setId(userId2);

        int chId = 10;
        Channel ch = new Channel();
        ch.setId(chId);
        ch.setMembers(new HashSet<>());
        ch.getMembers().add(user);
        ch.getMembers().add(user2);

        Channel updatedChannel = new Channel();
        updatedChannel.setId(chId);
        updatedChannel.setMembers(new HashSet<>());
        updatedChannel.getMembers().add(user);

        Mockito.when(userRepo.findById(userId2)).thenReturn(Optional.of(user2));
        Mockito.when(chRepo.findById(chId)).thenReturn(Optional.of(ch));
        Mockito.when(chRepo.save(any())).thenReturn(updatedChannel);

        Channel actual = chService.removeMember(chId, userId2);
        Assert.assertEquals(updatedChannel, actual);
        Assert.assertFalse(actual.getMembers().contains(user2));
    }

    @Test
    public void removeAdmin() {
        int userId = 1;
        User user = new User();
        user.setId(userId);

        int userId2 = 2;
        User user2 = new User();
        user2.setId(userId2);

        int chId = 10;
        Channel ch = new Channel();
        ch.setId(chId);
        ch.setAdmins(new HashSet<>());
        ch.getAdmins().add(user);
        ch.getAdmins().add(user2);

        Channel updatedChannel = new Channel();
        updatedChannel.setId(chId);
        updatedChannel.setAdmins(new HashSet<>());
        updatedChannel.getAdmins().add(user);

        Mockito.when(userRepo.findById(userId2)).thenReturn(Optional.of(user2));
        Mockito.when(chRepo.findById(chId)).thenReturn(Optional.of(ch));
        Mockito.when(chRepo.save(any())).thenReturn(updatedChannel);

        Channel actual = chService.removeAdmin(chId, userId2);
        Assert.assertEquals(updatedChannel, actual);
        Assert.assertFalse(actual.getAdmins().contains(user2));
    }

    @Test
    public void listAllAdmins() {
        int spaceId = 10;
        Channel channel = new Channel();
        channel.setId(spaceId);
        Mockito.when(chRepo.findById(spaceId)).thenReturn(Optional.of(channel));

        Assert.assertEquals(channel.getAdmins(), chService.listAllAdmins(spaceId));

    }

    @Test
    public void listAllMembers() {
        int spaceId = 10;
        Channel channel = new Channel();
        channel.setId(spaceId);
        Mockito.when(chRepo.findById(spaceId)).thenReturn(Optional.of(channel));

        Assert.assertEquals(channel.getMembers(), chService.listAllMembers(spaceId));
    }

    @Test
    public void delete() {
        int spaceId = 10;
        Channel channel = new Channel();
        channel.setId(spaceId);
        Mockito.when(chRepo.findById(spaceId)).thenReturn(Optional.of(channel));

        Assert.assertEquals(channel, chService.delete(spaceId));
    }


}
