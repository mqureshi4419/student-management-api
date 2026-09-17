package com.muhammad.studentapi.controller;

import com.muhammad.studentapi.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;

import com.muhammad.studentapi.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    private UserService userService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);

        UserController userController = new UserController(userService);

        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    @Test
    void loginReturnsOKWhenCredentialsAreCorrect() throws Exception {
        User testUser = new User(
                1,
                "admin@northfield.com",
                "admin123",
                "ADMIN"
        );

        when(userService.login("admin@northfield.com", "admin123"))
                .thenReturn(Optional.of(testUser));

        mockMvc.perform(post("/api/login")
                        .param("email", "admin@northfield.com")
                        .param("password", "admin123"))
                .andExpect(status().isOk());
    }

    @Test
    void loginReturnsUnauthorizedWhenCredentialsAreWrong() throws Exception {

        when(userService.login("admin@northfield.com", "wrong123"))
                .thenReturn(Optional.empty());

        mockMvc.perform(post("/api/login")
                        .param("email", "admin@northfield.com")
                        .param("password", "wrong123"))
                .andExpect(status().isUnauthorized());
    }

}
