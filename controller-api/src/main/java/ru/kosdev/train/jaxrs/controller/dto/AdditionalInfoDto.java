package ru.kosdev.train.jaxrs.controller.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created by kos on 07.05.16.
 */
public class AdditionalInfoDto {

    private LocalDate dateValue;

    @Size(max = 100, message = "The size of url is more than 100")
    private String urlValue;

    @Size(max = 20, message = "The size of text is more than 20")
    private String textValue;

    @Max(value = 100, message = "The int is bigger than 100")
    private Integer intValue;

    @Email(message = "email is invalid")
    @Size(max = 20, message = "The size of email is more than 20")
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
