package ru.kosdev.train.jaxrs.rest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Aspect
@Component
public class ServiceAspect {

    @Around("within(ru.kosdev.train.jaxrs.service.api.contract.UserService+)")
    public Object wrapExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed(); //continue on the intercepted method
        } catch (Throwable e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
