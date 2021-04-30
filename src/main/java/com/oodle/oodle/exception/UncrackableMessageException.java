package com.oodle.oodle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Amjad
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UncrackableMessageException extends RuntimeException {

    public UncrackableMessageException(String message) {
        super(message);
    }

}
