package ru.kosdev.train.jaxrs.controller.api;

/**
 * Created by kos on 05.06.16.
 */
public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(message);
    }
}
