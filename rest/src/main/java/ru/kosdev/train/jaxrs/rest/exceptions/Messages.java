package ru.kosdev.train.jaxrs.rest.exceptions;

import ru.kosdev.train.jaxrs.controller.api.BusinessException;

import javax.annotation.Nonnull;

/**
 * Created by kos on 07.06.16.
 */
public interface Messages {

    @Nonnull
    String getMessage(@Nonnull BusinessException e);
}
