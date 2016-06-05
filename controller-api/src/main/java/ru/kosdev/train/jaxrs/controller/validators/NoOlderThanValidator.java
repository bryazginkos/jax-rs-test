package ru.kosdev.train.jaxrs.controller.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * Created by kos on 05.06.16.
 */
public class NoOlderThanValidator implements ConstraintValidator<NoOlderThan, LocalDate> {

    private int years;

    @Override
    public void initialize(NoOlderThan noOlderThan) {
        years = noOlderThan.years();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) {
            return true;
        }
        final LocalDate now = LocalDate.now();
        final LocalDate yearsAgoDate = now.minusYears(years);
        return yearsAgoDate.isBefore(localDate);
    }
}
