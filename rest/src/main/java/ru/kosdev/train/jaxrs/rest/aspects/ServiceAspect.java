package ru.kosdev.train.jaxrs.rest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.rest.exceptions.ServiceException;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Aspect
@Component
public class ServiceAspect {

    @Around("within(ru.kosdev.train.jaxrs.service.api.contract.UserService+)")
    public Object wrapExceptions(final ProceedingJoinPoint joinPoint) throws ServiceException {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
