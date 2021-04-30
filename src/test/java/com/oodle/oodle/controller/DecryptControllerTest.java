package com.oodle.oodle.controller;

import com.oodle.oodle.dto.EncryptedMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DecryptControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void crackShouldReturnValidResponse() {
        var body1 = new EncryptedMessage("VJKUKUCUGETGVOGUUCIG", new String[]{"THI", "MES"});
        var request1 = restTemplate.postForObject("http://localhost:" + port + "/decrypt", body1, String.class);
        assertEquals("{\"plaintext\":\"THISISASECRETMESSAGE\"}", request1);

        var body2 = new EncryptedMessage("NKRRUCUXRJ", new String[]{"HELLO", "WORLD"});
        var request2 = restTemplate.postForObject("http://localhost:" + port + "/decrypt", body2, String.class);
        assertEquals("{\"plaintext\":\"HELLOWORLD\"}", request2);

        var body3 = new EncryptedMessage("CNQILEM", new String[]{"IT", "WORK"});
        var request3 = restTemplate.postForObject("http://localhost:" + port + "/decrypt", body3, String.class);
        assertEquals("{\"plaintext\":\"ITWORKS\"}", request3);
    }

}