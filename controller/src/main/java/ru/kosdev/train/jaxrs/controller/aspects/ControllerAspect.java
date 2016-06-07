package ru.kosdev.train.jaxrs.controller.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.common.MessageCode;
import ru.kosdev.train.jaxrs.controller.api.BusinessException;
import ru.kosdev.train.jaxrs.controller.api.ImageNotFoundException;

/**
 * Created by kbryazgin on 5/11/2016.
 */
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(* ru.kosdev.train.jaxrs.controller.api.*.*(..))")
    public void controllers() {
    }

    @Around("controllers()")
    public Object wrapExceptions(final ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (BusinessException | ImageNotFoundException e) {
            throw e;
        } catch (Throwable e) {
            throw new BusinessException(MessageCode.ERR_UNKNOWN, e.getMessage());
        }
    }
}
