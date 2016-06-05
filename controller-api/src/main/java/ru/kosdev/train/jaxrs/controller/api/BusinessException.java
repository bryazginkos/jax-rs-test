package ru.kosdev.train.jaxrs.controller.api;

/**
 * Created by kos on 05.06.16.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
