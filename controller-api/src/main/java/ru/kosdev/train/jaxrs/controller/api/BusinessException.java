package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.common.MessageCode;

import java.util.Arrays;

/**
 * Created by kos on 05.06.16.
 */
public class BusinessException extends RuntimeException {

    private final MessageCode messageCode;

    private final Object[] args;

    public BusinessException(final MessageCode code, final Object... args) {
        super(code.getKey());
        this.messageCode = code;
        this.args = args;
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

    public Object[] getArgs() {
        if (args == null) {
            return null;
        }
        return Arrays.copyOf(args, args.length);
    }
}
