/**
 * Exception thrown when an entity with the specified identifier
 */
package com.learntrack.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
