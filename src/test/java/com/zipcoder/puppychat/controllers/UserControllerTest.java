package com.zipcoder.puppychat.controllers;

import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    public void getUser() {
        Mockito.when(service.findById(10)).thenReturn(new User());
        Assert.assertEquals(HttpStatus.OK, controller.getUser(10).getStatusCode());
    }

    @Test
    public void getAllUser() {
        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());
        Assert.assertEquals(HttpStatus.OK, controller.getAllUser().getStatusCode());
    }

    @Test
    public void createUser() {
        User user = new User();
        Mockito.when(service.create(user)).thenReturn(user);
        Assert.assertEquals(HttpStatus.OK, controller.createUser(user).getStatusCode());
    }

    @Test
    public void loginTest() {
        User user = new User();
        user.setPassword("friend");
        user.setEmail("abc");
        Mockito.when(service.login(user.getEmail(), user.getPassword())).thenReturn(user);
        Assert.assertEquals(HttpStatus.OK, controller.login(user).getStatusCode());
    }

    @Test
    public void updatePassword() {
        Mockito.when(service.changePassword(10, "Password")).thenReturn(new User());
        Assert.assertEquals(HttpStatus.OK, controller.updatePassword(10, "Password").getStatusCode());
    }

    @Test
    public void updateEmail() {
        Mockito.when(service.changeEmail(10, "user@gmail.com")).thenReturn(new User());
        Assert.assertEquals(HttpStatus.OK, controller.updateEmail(10, "user@gmail.com").getStatusCode());
    }

    @Test
    public void updateDisplayName() {
        Mockito.when(service.changeDisplayName(10, "Romeo")).thenReturn(new User());
        Assert.assertEquals(HttpStatus.OK, controller.updateDisplayName(10, "Romeo").getStatusCode());
    }

    @Test
    public void deleteUser() {
        Mockito.when(service.delete(10)).thenReturn(new User());
        Assert.assertEquals(HttpStatus.OK, controller.deleteUser(10).getStatusCode());
    }
}
