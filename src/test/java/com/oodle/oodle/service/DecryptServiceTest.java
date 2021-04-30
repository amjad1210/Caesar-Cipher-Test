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
public class DecryptServiceTest {

    private DecryptService decryptService;

    @BeforeEach
    public void setUp() {
        decryptService = new DecryptService();
    }

    @Test
    void crackMessageExceptions() {
        //Message contains spaces.
        var containsSpace = new EncryptedMessage("VJKUKU CUGETGV OGUUCIG", new String[]{"THI", "MES"});
        assertThrows(InvalidMessageException.class, () -> {
            decryptService.decryptMessage(containsSpace);
        });

        //Message contains lowercase characters.
        var containsLowercase = new EncryptedMessage("VJKUKUCUGETGVOGUUdfIG", new String[]{"THI", "MES"});
        assertThrows(InvalidMessageException.class, () -> {
            decryptService.decryptMessage(containsLowercase);
        });
    }

    @Test
    void crackMessagePositiveShift() {
        var valid1 = new EncryptedMessage("VJKUKUCUGETGVOGUUCIG", new String[]{"THI", "MES"});
        assertEquals("THISISASECRETMESSAGE", decryptService.decryptMessage(valid1).getPlainText());

        var valid2 = new EncryptedMessage("NKRRUCUXRJ", new String[]{"HELLO", "WORLD"});
        assertEquals("HELLOWORLD", decryptService.decryptMessage(valid2).getPlainText());

        var valid3 = new EncryptedMessage("CNQILEM", new String[]{"IT", "WORK"});
        assertEquals("ITWORKS", decryptService.decryptMessage(valid3).getPlainText());
    }

    @Test
    void crackMessageNegativeShift() {
        var valid1 = new EncryptedMessage("OCDNDNVNZXMZOHZNNVBZ", new String[]{"THI", "MES"});
        assertEquals("THISISASECRETMESSAGE", decryptService.decryptMessage(valid1).getPlainText());

        var valid2 = new EncryptedMessage("LIPPSASVPH", new String[]{"HEL", "WOR"});
        assertEquals("HELLOWORLD", decryptService.decryptMessage(valid2).getPlainText());

        var valid3 = new EncryptedMessage("BMPHKDL", new String[]{"IT", "WOR"});
        assertEquals("ITWORKS", decryptService.decryptMessage(valid3).getPlainText());
    }

}