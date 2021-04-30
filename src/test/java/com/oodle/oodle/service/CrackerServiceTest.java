package com.oodle.oodle.service;

import com.oodle.oodle.dto.EncryptedMessage;
import com.oodle.oodle.exception.InvalidMessageException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Amjad
 */
public class CrackerServiceTest {

    private CrackerService crackerService;

    @BeforeEach
    public void setUp() {
        crackerService = new CrackerService();
    }

    @Test
    void crackMessageExceptions() {
        //Message contains spaces.
        var containsSpace = new EncryptedMessage("VJKUKU CUGETGV OGUUCIG", new String[]{"THI", "MES"});
        assertThrows(InvalidMessageException.class, () -> {
            crackerService.crackMessage(containsSpace);
        });

        //Message contains lowercase characters.
        var containsLowercase = new EncryptedMessage("VJKUKUCUGETGVOGUUdfIG", new String[]{"THI", "MES"});
        assertThrows(InvalidMessageException.class, () -> {
            crackerService.crackMessage(containsLowercase);
        });
    }

    @Test
    void crackMessagePositiveShift() {
        var valid1 = new EncryptedMessage("VJKUKUCUGETGVOGUUCIG", new String[]{"THI", "MES"});
        assertEquals("THISISASECRETMESSAGE", crackerService.crackMessage(valid1).getPlainText());

        var valid2 = new EncryptedMessage("NKRRUCUXRJ", new String[]{"HELLO", "WORLD"});
        assertEquals("HELLOWORLD", crackerService.crackMessage(valid2).getPlainText());

        var valid3 = new EncryptedMessage("CNQILEM", new String[]{"IT", "WORK"});
        assertEquals("ITWORKS", crackerService.crackMessage(valid3).getPlainText());
    }

    @Test
    void crackMessageNegativeShift() {
        var valid1 = new EncryptedMessage("OCDNDNVNZXMZOHZNNVBZ", new String[]{"THI", "MES"});
        assertEquals("THISISASECRETMESSAGE", crackerService.crackMessage(valid1).getPlainText());

        var valid2 = new EncryptedMessage("LIPPSASVPH", new String[]{"HEL", "WOR"});
        assertEquals("HELLOWORLD", crackerService.crackMessage(valid2).getPlainText());

        var valid3 = new EncryptedMessage("BMPHKDL", new String[]{"IT", "WOR"});
        assertEquals("ITWORKS", crackerService.crackMessage(valid3).getPlainText());
    }

}