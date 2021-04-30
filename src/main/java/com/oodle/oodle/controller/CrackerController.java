package com.oodle.oodle.controller;

import com.oodle.oodle.dto.DecryptedResponse;
import com.oodle.oodle.dto.EncryptedMessage;
import com.oodle.oodle.service.CrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Amjad
 */
@RestController
public class CrackerController {

    private final CrackerService crackerService;

    @Autowired
    public CrackerController(CrackerService crackerService) {
        this.crackerService = crackerService;
    }

    @PostMapping("/crack")
    public DecryptedResponse crackPayload(@RequestBody EncryptedMessage encryptedMessage) {
        return crackerService.crackMessage(encryptedMessage);
    }

}
