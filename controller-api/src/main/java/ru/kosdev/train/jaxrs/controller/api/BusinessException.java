package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.common.MessageCode;

/**
 * Created by kos on 05.06.16.
 */
public class BusinessException extends RuntimeException {

    private MessageCode messageCode;

    private Object[] args;

    public BusinessException(final MessageCode code, Object... args) {
        super(code.getKey());
        this.messageCode = code;
        this.args = args;
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
