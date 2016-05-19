package ru.kosdev.train.jaxrs.service.api.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import java.time.LocalDate;

/**
 * Created by kos on 07.05.16.
 */
public class AdditionalInfoDto {

    private LocalDate dateValue;

    private String urlValue;

    private String textValue;

    @Max(value = 100, message = "The int is bigger than 100")
    private Integer intValue;

    @Email(message = "email is invalid")
    private String emailValue;

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(final LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    public String getUrlValue() {
        return urlValue;
    }

    public void setUrlValue(final String urlValue) {
        this.urlValue = urlValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(final String textValue) {
        this.textValue = textValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(final Integer intValue) {
        this.intValue = intValue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(final String emailValue) {
        this.emailValue = emailValue;
    }
}
