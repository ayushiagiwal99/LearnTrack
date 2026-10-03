/**
 * Exception thrown when user-provided input does not meet the
 * required validation rules.
 */
package main.java.org.learnTrack.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
