package com.site.joblisting.dao;

import com.site.joblisting.dao.impl.UserDaoImpl;
import com.site.joblisting.dto.UserResponseDTO;
import com.site.joblisting.entities.User;
import com.site.joblisting.repositories.UserJobRepository;
import com.site.joblisting.repositories.UserRepository;
import com.site.joblisting.security.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDaoImpl_Test {

    @Mock
    UserRepository userRepository;

    @Mock
    UserJobRepository userJobRepository;

    @InjectMocks
    UserDaoImpl userDaoImplSpringDataJpa;

    @Test
    public void getAllUsersTest() {

        when(userRepository.findAll()).thenReturn(List.of(new User(1, "user", "pwd123", "user@admin.com", UserRole.USER.getAuthority())));

        List<UserResponseDTO> actual = userDaoImplSpringDataJpa.getAllUsers();

        List<UserResponseDTO> expected = List.of(UserResponseDTO.builder().id(1).name("user").email("user@admin.com").role(UserRole.USER.getAuthority()).build());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllJobIdByUserIdTest() {
        when(userRepository.findById(1)).thenReturn(Optional.of(new User(1, "user", "pwd123", "user@admin.com", UserRole.USER.getAuthority())));
        when(userJobRepository.findAllJobIdByUserId(1)).thenReturn(List.of(1, 2, 3));

        List<Integer> actual = userDaoImplSpringDataJpa.getAllJobIdByUserId(1);
        List<Integer> expected = List.of(1, 2, 3);

        Assertions.assertEquals(expected, actual);
    }
}
