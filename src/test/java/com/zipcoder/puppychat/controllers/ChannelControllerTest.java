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

import java.util.HashSet;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ChannelControllerTest {

    @Mock
    ChannelService channelService;

    @InjectMocks
    ChannelController channelController;

    @Test
    public void getChannel() {
        Mockito.when( channelService.findById(999) ).thenReturn( new Channel() );
        Assert.assertEquals( HttpStatus.OK , channelController.getChannel(999).getStatusCode() );
    }

    @Test
    public void getAllManagedChannels() {
        Mockito.when( channelService.findAllByAnAdmin(888) ).thenReturn( new HashSet<>() );
        Assert.assertEquals( HttpStatus.OK , channelController.getAllManagedChannels(888).getStatusCode() );
    }

    @Test
    public void getAllSubscribedChannel() {
        Mockito.when( channelService.findAllByAMember(777) ).thenReturn( new HashSet<>() );
        Assert.assertEquals( HttpStatus.OK , channelController.getAllSubscribedChannel(777).getStatusCode() );
    }

    @Test
    public void getAllAdminsByChannel() {
        Mockito.when( channelService.listAllAdmins(777) ).thenReturn( new HashSet<>() );
        Assert.assertEquals( HttpStatus.OK , channelController.getAllAdminsByChannel(777).getStatusCode() );
    }

    @Test
    public void getAllMembersByChannel() {
        Mockito.when(channelService.listAllMembers(888) ).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, channelController.getAllAdminsByChannel(888).getStatusCode());
    }

    @Test
    public void createChannel() {
        Mockito.when(channelService.listAllMembers(773)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, channelController.getAllAdminsByChannel(773).getStatusCode());
    }

    @Test
    public void updateChannelName() {
    }

    @Test
    public void addMember() {
    }

    @Test
    public void addAdmin() {
    }

    @Test
    public void deleteChannel() {
    }

    @Test
    public void removeMember() {
    }

    @Test
    public void removeAdmin() {
    }
}