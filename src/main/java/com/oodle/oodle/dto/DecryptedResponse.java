package com.oodle.oodle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * @author Amjad
 */
@AllArgsConstructor
@Value
public class DecryptedResponse {

    @JsonProperty("plaintext")
    String plainText;

}
