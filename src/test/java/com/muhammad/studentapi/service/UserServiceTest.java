package com.muhammad.studentapi.service;
import com.muhammad.studentapi.model.User;
import com.muhammad.studentapi.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);

    }

    @Test
    void loginWithCorrectCredentialsReturnsUser() {

        User testUser = new User(
                1,
                "admin@northfield.com",
                "admin123",
                "ADMIN"
        );

        when(userRepository.findByEmail("admin@northfield.com"))
                .thenReturn(Optional.of(testUser));

        Optional<User> result =
                userService.login("admin@northfield.com", "admin123");

        assertTrue(result.isPresent());
        assertEquals("admin@northfield.com", result.get().getEmail());
    }

    @Test
    void loginWithWrongPasswordReturnsEmpty() {
        User testUser = new User(
                1,
                "admin@northfield.com",
                "admin123",
                "ADMIN"
        );

        when(userRepository.findByEmail("admin@northfield.com"))
                .thenReturn(Optional.of(testUser));

        Optional<User> result =
                    userService.login("admin@northfield.com", "wrong123");

        assertTrue(result.isEmpty());
    }

    @Test
    void loginWithUnknownEmailReturnsEmpty() {
        when(userRepository.findByEmail("missing@northfield.com"))
                .thenReturn(Optional.empty());

        Optional<User> result =
                userService.login("missing@northfield.com", "anything");

        assertTrue(result.isEmpty());
    }


}
