package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.Channel;
import com.zipcoder.puppychat.services.ChannelService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.lang.reflect.Member;
import java.util.HashSet;

@RunWith(MockitoJUnitRunner.class)
public class ChannelControllerTest {

    @Mock
    ChannelService channelService;

    @InjectMocks
    ChannelController channelController;

    @Test
    public void getChannel() {
        Mockito.when(channelService.findById(999)).thenReturn(new Channel());
        Assert.assertEquals(HttpStatus.OK, channelController.getChannel(999).getStatusCode());
    }

    @Test
    public void getAllManagedChannels() {
        Mockito.when(channelService.findAllByAnAdmin(888)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, channelController.getAllManagedChannels(888).getStatusCode());
    }

    @Test
    public void getAllSubscribedChannel() {
        Mockito.when(channelService.findAllByAMember(777)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, channelController.getAllSubscribedChannel(777).getStatusCode());
    }

    @Test
    public void getAllAdminsByChannel() {
        Mockito.when(channelService.listAllAdmins(777)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, channelController.getAllAdminsByChannel(777).getStatusCode());
    }

    @Test
    public void getAllMembersByChannel() {
        Assert.assertEquals(HttpStatus.OK, channelController.getAllAdminsByChannel(888).getStatusCode());
    }

    @Test
    public void createChannel() {
        Channel channel = new Channel();
        Assert.assertEquals(HttpStatus.OK, channelController.getAllAdminsByChannel(773).getStatusCode());
    }

    @Test
    public void updateChannelName() {
        Channel channel = new Channel();
        Assert.assertEquals(HttpStatus.OK, channelController.updateChannelName(999, "Kathy").getStatusCode());
    }

    @Test
    public void addMember() {
        Channel channel = new Channel();
        Mockito.when(channelService.addMember(000, 111)).thenReturn(channel);
        Assert.assertEquals(HttpStatus.OK, channelController.addMember(111, 000).getStatusCode());
    }

    @Test
    public void addAdmin() {
        Channel channel = new Channel();
        Mockito.when(channelService.addAdmin(555, 999)).thenReturn(channel);
        Assert.assertEquals(HttpStatus.OK, channelController.addAdmin(999, 555).getStatusCode());
    }

    @Test
    public void deleteChannel() {
        Mockito.when(channelService.delete(888)).thenReturn(new Channel());
        Assert.assertEquals(HttpStatus.OK, channelController.deleteChannel(888).getStatusCode());
    }

    @Test
    public void removeMember() {
        Mockito.when(channelService.removeMember(888, 999)).thenReturn(new Channel());
        Assert.assertEquals(HttpStatus.OK, channelController.removeMember(999, 888).getStatusCode());
    }

    @Test
    public void removeAdmin() {
        Mockito.when(channelService.removeAdmin(111, 222)).thenReturn(new Channel());
        Assert.assertEquals(HttpStatus.OK, channelController.removeAdmin(222, 111).getStatusCode());
    }
}