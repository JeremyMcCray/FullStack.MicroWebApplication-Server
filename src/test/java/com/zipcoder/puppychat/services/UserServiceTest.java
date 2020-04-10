package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;

    @Test
    public void findById() {
        User u = new User();
        User u2 = new User();



        repository.findAll();
    }

    @Test
    public void findAll() {
    }

    @Test
    public void create() {
        int uid = 1;

        User u = new User();
        u.setId(uid);
        u.setDisplayName("Tom");
        u.setEmail("tomsEmail@email.com");

        Mockito.when(repository.findById(uid)).thenReturn(Optional.of(u));
        Mockito.when(repository.save(any())).thenReturn(u);


        Assert.assertEquals( u,service.findById(1));


    }

    @Test
    public void changePassword() {
        int uid = 1;
        User u = new User();

        u.setPassword("pass");

        Mockito.when(repository.findById(uid)).thenReturn(Optional.of(u));
        Mockito.when(repository.save(any())).thenReturn(u);

       Assert.assertEquals(u,service.changePassword(1,"poss"));
       Assert.assertEquals(u.getPassword(),"poss");

    }

    @Test
    public void changeEmail() {
        int uid = 1;
        User u = new User();

        u.setEmail("tomsEmail@Email.com");

        Mockito.when(repository.findById(uid)).thenReturn(Optional.of(u));
        Mockito.when(repository.save(any())).thenReturn(u);

        Assert.assertEquals(u,service.changeEmail(1,"poss"));
        Assert.assertEquals(u.getEmail(),"poss");
    }

    @Test
    public void changeDisplayName() {
    }

    @Test
    public void delete() {
    }
}