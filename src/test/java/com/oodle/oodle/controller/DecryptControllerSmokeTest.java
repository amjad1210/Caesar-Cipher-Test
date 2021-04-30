package com.oodle.oodle.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DecryptControllerSmokeTest {

    @Autowired
    private DecryptController decryptController;

    @Test
    void contextLoads() {
        assertNotNull(decryptController);
    }

}