package com.site.joblisting.dao;

import com.site.joblisting.entities.User;
import com.site.joblisting.repositories.UserJobRepository;
import com.site.joblisting.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDaoImpl_springDataJpaTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserJobRepository userJobRepository;

    @InjectMocks
    UserDaoImpl_springDataJpa userDaoImplSpringDataJpa;

    @Test
    public void getAllUsersTest() {

        when(userRepository.findAll()).thenReturn(List.of(new User(1, "user", "pwd123","user@admin.com", "user")));

        List<User> actual = userDaoImplSpringDataJpa.getAllUsers();

        List<User> expected = List.of(new User(1, "user", "pwd123","user@admin.com", "user"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllJobIdByUserIdTest() {
        when(userJobRepository.findAllJobIdByUserId(1)).thenReturn(List.of(1,2,3));

        List<Integer> actual = userDaoImplSpringDataJpa.getAllJobIdByUserId(1);
        List<Integer> expected = List.of(1,2,3);

        Assertions.assertEquals(expected, actual);
    }
}
