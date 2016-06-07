package ru.kosdev.train.jaxrs.rest.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.api.BusinessException;

import javax.annotation.Nonnull;
import java.util.Locale;

/**
 * Created by kos on 07.06.16.
 */
@Component
public class MessagesImpl implements Messages {

    @Autowired
    @Qualifier("resourceBundleMessageSource")
    private MessageSource messageSource;

    @Autowired
    ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

    @Override
    @Nonnull
    public String getMessage(@Nonnull BusinessException e) {
        try {
            return messageSource.getMessage(e.getMessageCode().getKey(), e.getArgs(),
                    Locale.US);
        } catch (NoSuchMessageException nsmE) {
            return e.getMessage();
        }
    }

}
