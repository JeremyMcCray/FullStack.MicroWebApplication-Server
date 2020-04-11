package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.services.DMSpaceService;
import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.logging.Handler;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DMSpaceControllerTest {

    @Mock
    DMSpaceService dmSpaceService;

    @InjectMocks
    DMSpaceController dmSpaceController;

    @Test
    public void getDMSpace() {
        Mockito.when(dmSpaceService.findById(888)).thenReturn(new DMSpace());
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.getDMSpace(888).getStatusCode());
    }

    @Test
    public <E> void getAllDMSpaceByUser() {
        Mockito.when(dmSpaceService.findAllByAMember(888)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.getAllDMSpaceByUser(888).getStatusCode());
    }

    @Test
    public void listAllMembers() {
        Mockito.when(dmSpaceService.listAllMembers(888)).thenReturn(new HashSet<>());
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.listAllMembers(888).getStatusCode());
    }

    @Test
    public void createDMSpace() {
        DMSpace dmSpace = new DMSpace();
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.createDMSpace(888, 999).getStatusCode());
    }

    @Test
    public void addMemberToDMSpace() {
        DMSpace dmSpace = new DMSpace();
        Mockito.when(dmSpaceService.addMember(800, 1)).thenReturn(dmSpace);
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.addMemberToDMSpace(800, 1).getStatusCode());
    }

    @Test
    public void deleteDMSpace() {
        Mockito.when(dmSpaceService.delete(888)).thenReturn(new DMSpace());
        Assert.assertEquals(HttpStatus.OK, dmSpaceController.deleteDMSpace(888).getStatusCode());

    }
}