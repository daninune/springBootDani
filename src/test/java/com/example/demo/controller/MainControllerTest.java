package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // disabled
@RunWith(SpringRunner.class)
@Controller
public class MainControllerTest {

    @Autowired
    private MainController mainController;
    private MockMvc controller;

    @Before
    public void setup() {
        this.controller = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    @WithUserDetails("santi.vazquez")
    public void testMainControllerIndex() throws Exception {
        Authentication anAuthentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(anAuthentication);
        SecurityContextHolder.setContext(context);
        this.controller.perform(get("/main/")).andExpect(status().isOk());
    }

}
