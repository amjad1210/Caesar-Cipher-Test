package com.oodle.oodle.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CrackerControllerSmokeTest {

    @Autowired
    private CrackerController crackerController;

    @Test
    void contextLoads() {
        assertNotNull(crackerController);
    }

}