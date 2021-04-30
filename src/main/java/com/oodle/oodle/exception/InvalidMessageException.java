package com.oodle.oodle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Amjad
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidMessageException extends RuntimeException {

    public InvalidMessageException(String message) {
        super(message);
    }

}
