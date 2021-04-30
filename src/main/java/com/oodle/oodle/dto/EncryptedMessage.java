package com.oodle.oodle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * @author Amjad
 */
@AllArgsConstructor
@Value
public class EncryptedMessage {

    @JsonProperty("ciphertext")
    String cipherText;

    @JsonProperty("cribs")
    String[] cribs;

}
