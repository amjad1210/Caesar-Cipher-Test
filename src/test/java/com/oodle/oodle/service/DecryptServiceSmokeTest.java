package com.oodle.oodle.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Amjad
 */
@SpringBootTest
public class DecryptServiceSmokeTest {

    @Autowired
    private DecryptService decryptService;

    @Test
    void contextLoads() {
        assertNotNull(decryptService);
    }

}