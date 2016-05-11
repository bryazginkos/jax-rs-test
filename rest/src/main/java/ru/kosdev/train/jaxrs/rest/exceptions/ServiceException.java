package ru.kosdev.train.jaxrs.rest.exceptions;

/**
 * Created by kbryazgin on 5/11/2016.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
