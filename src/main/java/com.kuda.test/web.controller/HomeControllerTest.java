package com.kuda.test.web.controller;

import com.kuda.common.LoginDelegate;
import com.kuda.common.service.UserService;
import com.kuda.web.controller.HomeController;
import com.kuda.web.controller.LoginBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

public class HomeControllerTest {
    @Mock
    private LoginDelegate loginDelegate;

    @InjectMocks
    private HomeController homeController;
    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

    }

    @Test
    public void testHome() throws Exception {

    }

    @Test
    public void testGetHome() throws Exception {

    }

    @Test
    public void testGetDetail() throws Exception {

    }

    @Test
    public void testLogin() throws Exception {

    }

    @Test
    public void testLogout() throws Exception {
        this.mockMvc.perform(get("/signout"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("msg", "You have logged out"))
                .andExpect(forwardedUrl("login"));
    }

    @Test(expected = NestedServletException.class)
    public void testSubmit() throws Exception {
        when(loginDelegate.isValidUser(any(String.class),any(String.class)))
                .thenThrow(new RuntimeException("For Testing"));

        this.mockMvc.perform(post("/signin")
                .param("userName", "admin1")
                .param("password", "admin1"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/home"));
    }
}