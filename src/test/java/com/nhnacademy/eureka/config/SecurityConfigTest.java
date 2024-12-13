package com.nhnacademy.eureka.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityConfigTest {

    @Test
    public void testBCryptPasswordEncoder() {
        SecurityConfig securityConfig = new SecurityConfig();
        BCryptPasswordEncoder encoder = securityConfig.bCryptPasswordEncoder();
        assertNotNull(encoder);
        String password = "1234";
        String encodedPassword = encoder.encode(password);
        assertTrue(encoder.matches(password, encodedPassword));
    }

    @Test
    public void testUserDetailsService() {
        SecurityConfig securityConfig = new SecurityConfig();
        UserDetailsService userDetailsService = securityConfig.userDetailsService();
        assertNotNull(userDetailsService);
        assertNotNull(userDetailsService.loadUserByUsername("user1"));
    }


}