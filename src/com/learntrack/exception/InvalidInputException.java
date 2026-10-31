/**
 * Exception thrown when user-provided input does not meet the
 * required validation rules.
 */
package com.learntrack.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
