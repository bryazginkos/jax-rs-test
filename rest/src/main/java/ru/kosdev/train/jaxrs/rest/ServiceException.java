package ru.kosdev.train.jaxrs.rest;

/**
 * Created by kbryazgin on 5/11/2016.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }
}
