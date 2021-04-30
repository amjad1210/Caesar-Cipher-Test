package com.oodle.oodle.service;

import com.oodle.oodle.dto.DecryptedResponse;
import com.oodle.oodle.dto.EncryptedMessage;
import com.oodle.oodle.exception.InvalidMessageException;
import com.oodle.oodle.exception.UncrackableMessageException;
import org.springframework.stereotype.Service;

/**
 * @author Amjad
 */
@Service
public class DecryptService {

    /**
     * Decrypt message and return plaintext response.
     *
     * @param encryptedMessage
     * @return decryptedResponse
     */
    public DecryptedResponse decryptMessage(EncryptedMessage encryptedMessage) {
        var message = encryptedMessage.getCipherText();
        var cribs = encryptedMessage.getCribs();

        //Check if encrypted message is all uppercase and has no spaces.
        if (!isValid(message)) {
            throw new InvalidMessageException("Invalid cipher text: " + message);
        }

        int offset = 0;
        while (true) {
            //Decrypted message.
            var decryptedMessage = cipher(message, offset).toUpperCase();
            //Check if decrypted message is valid.
            var cracked = containsCribs(decryptedMessage, cribs);
            //Check if decrypted message is valid, all uppercase and has no spaces.
            if (cracked && isValid(decryptedMessage)) {
                return new DecryptedResponse(decryptedMessage);
            }

            //In case we ever hit the maximum integer.
            if (offset == Integer.MAX_VALUE) {
                throw new UncrackableMessageException("Unable to crack message: " + message);
            }
            offset++;
        }
    }

    /**
     * Check if message is all uppercase and has no spaces.
     *
     * @param message
     * @return valid
     */
    private boolean isValid(String message) {
        var isUppercase = isUpperCase(message);
        return !message.contains(" ") && isUppercase;
    }

    /**
     * Check if string is all uppercase.
     *
     * @param string
     * @return uppercase
     */
    private boolean isUpperCase(String string) {
        for (var i = 0; i < string.length(); i++) {
            if (!Character.isUpperCase(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Use cipher algorithm with an offset to decrypt a message.
     *
     * @param message
     * @param offset
     * @return decryptedMessage
     */
    private String cipher(String message, int offset) {
        var result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                var originalAlphabetPosition = character - 'a';
                //Move character to new position according to offset.
                var newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                //New character from
                var newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Validate decrypted message against cribs.
     *
     * @param message
     * @param cribs
     * @return containsCribs
     */
    private boolean containsCribs(String message, String[] cribs) {
        for (var crib : cribs) {
            if (!message.contains(crib)) {
                return false;
            }
        }
        return true;
    }

}
