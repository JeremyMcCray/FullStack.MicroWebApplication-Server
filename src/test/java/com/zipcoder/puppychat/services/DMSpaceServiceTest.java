package com.zipcoder.puppychat.services;

import com.zipcoder.puppychat.models.DMSpace;
import com.zipcoder.puppychat.models.User;
import com.zipcoder.puppychat.repositories.DMSpaceRepository;
import com.zipcoder.puppychat.repositories.UserRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class DMSpaceServiceTest {

    @Mock
    DMSpaceRepository dmRepo;

    @Mock
    UserRepository userRepo;

    @InjectMocks
    DMSpaceService dms;

    @Test
    public void findById() {
        int spaceId = 10;
        DMSpace space = new DMSpace();
        Mockito.when(dmRepo.findById(spaceId)).thenReturn(Optional.of(space));
        Assert.assertEquals(space,dms.findById(spaceId));
    }

    @Test
    public void findAllByAMember() {
        DMSpace space1 = new DMSpace();
        DMSpace space2 = new DMSpace();
        Set<DMSpace> set = new HashSet<>();
        set.add(space1);
        set.add(space2);
        int userId = 1;
        User user = new User();
        user.setId(userId);
        user.setDm(set);

        Mockito.when(dmRepo.findDMSpacesByMembers(user)).thenReturn(set);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Assert.assertEquals(2,dms.findAllByAMember(userId).spliterator().getExactSizeIfKnown());
    }

    @Test
    public void create() {
        int userId = 1;
        int userId2 = 2;
        User user = new User();
        User user2 = new User();
        user.setId(userId);
        user2.setId(userId2);
        Set<User> s = new HashSet<>();
        s.add(user);
        s.add(user2);
        DMSpace space = new DMSpace();
        space.setMembers(s);

        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.findById(userId2)).thenReturn(Optional.of(user2));
        Mockito.when(dmRepo.save(any())).thenReturn(space);

        DMSpace actual = dms.create(userId,userId2);
        Assert.assertEquals(s.size(),actual.getMembers().spliterator().getExactSizeIfKnown());
    }

    @Test
    public void addMember() {
        int spaceId = 10;
        DMSpace space = new DMSpace();
        space.setId(spaceId);

        int userId = 1;
        User user = new User();
        user.setId(userId);

        DMSpace updatedSpace = new DMSpace();
        updatedSpace.setId(spaceId);
        updatedSpace.setMembers(new HashSet<>());
        updatedSpace.getMembers().add(user);
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(dmRepo.findById(spaceId)).thenReturn(Optional.of(space));
        Mockito.when(dmRepo.save(any())).thenReturn(updatedSpace);

        Assert.assertEquals(updatedSpace,dms.addMember(spaceId,userId));

    }

    @Test
    public void listAllMembers() {
        int spaceId = 10;
        DMSpace space = new DMSpace();
        space.setId(spaceId);
        Mockito.when(dmRepo.findById(spaceId)).thenReturn(Optional.of(space));

        Assert.assertEquals(space.getMembers(),dms.listAllMembers(spaceId));
    }

    @Test
    public void delete() {
        int spaceId = 10;
        DMSpace space = new DMSpace();
        space.setId(spaceId);
        Mockito.when(dmRepo.findById(spaceId)).thenReturn(Optional.of(space));

        Assert.assertEquals(space,dms.delete(spaceId));
    }
}