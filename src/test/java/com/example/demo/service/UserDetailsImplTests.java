package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsImplTests {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername("santi.vazquez");
        assert (userDetails.getUsername().equals("santi.vazquez"));
    }

}
