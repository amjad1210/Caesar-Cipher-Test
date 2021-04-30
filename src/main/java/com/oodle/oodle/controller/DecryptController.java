package com.oodle.oodle.controller;

import com.oodle.oodle.dto.DecryptedResponse;
import com.oodle.oodle.dto.EncryptedMessage;
import com.oodle.oodle.service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amjad
 */
@RestController
public class DecryptController {

    private final DecryptService decryptService;

    @Autowired
    public DecryptController(DecryptService decryptService) {
        this.decryptService = decryptService;
    }

    @PostMapping("/decrypt")
    public DecryptedResponse decryptPayload(@RequestBody EncryptedMessage encryptedMessage) {
        return decryptService.decryptMessage(encryptedMessage);
    }

}
