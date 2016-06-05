package ru.kosdev.train.jaxrs.controller.api;

/**
 * Created by kos on 04.06.16.
 */
public class IncorrectDataException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IncorrectDataException(String message) {
        super(message);
    }
}
