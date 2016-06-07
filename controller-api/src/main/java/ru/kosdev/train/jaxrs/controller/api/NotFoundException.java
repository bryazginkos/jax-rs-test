package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.common.MessageCode;

/**
 * Created by kos on 05.06.16.
 */
public class NotFoundException extends BusinessException {

    public NotFoundException(MessageCode code, Object... args) {
        super(code, args);
    }
}
