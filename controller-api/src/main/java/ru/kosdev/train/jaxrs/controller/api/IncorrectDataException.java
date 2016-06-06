package ru.kosdev.train.jaxrs.controller.api;

/**
 * Created by kos on 04.06.16.
 */
public class IncorrectDataException extends BusinessException {

    public IncorrectDataException(final String message) {
        super(message);
    }
}
