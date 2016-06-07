package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.common.MessageCode;

/**
 * Created by kos on 04.06.16.
 */
public class IncorrectDataException extends BusinessException {

    public IncorrectDataException(MessageCode code, Object... args) {
        super(code, args);
    }
}
