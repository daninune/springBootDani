package com.example.demo.controller;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@RestController
public class MainControllerTest {
    @Autowired
    private MainController mainController;
    private MockMvc controller;

    @Before
    public void setup(){
        this.controller = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testMainControllerIndex() throws Exception {
        this.controller.perform(get("/")).andExpect(status().isOk());
    }





}
