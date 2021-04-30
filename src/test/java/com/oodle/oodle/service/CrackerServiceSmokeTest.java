package com.oodle.oodle.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Amjad
 */
@SpringBootTest
public class CrackerServiceSmokeTest {

    @Autowired
    private CrackerService crackerService;

    @Test
    void contextLoads() {
        assertNotNull(crackerService);
    }

}