package ru.kosdev.train.jaxrs.controller.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by kos on 05.06.16.
 */
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = NoOlderThanValidator.class)
public @interface NoOlderThan {

    String message() default "The date is too old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int years() default 0;
}
