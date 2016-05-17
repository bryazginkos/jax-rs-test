package ru.kosdev.train.jaxrs.service.api.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by kos on 07.05.16.
 */
public class AdditionalInfoDto {

    private Date dateValue;

    private String urlValue;

    private String textValue;

    @Max(value = 100, message = "The int is bigger than 100")
    private Integer intValue;

    @Email(message = "email is invalid")
    private String emailValue;

    public Date getDateValue() {
        if (dateValue == null) {
            return null;
        }
        return new Date(dateValue.getTime());
    }

    public void setDateValue(final Date dateValue) {
        if (dateValue == null) {
            this.dateValue = null;
        } else {
            this.dateValue = new Date(dateValue.getTime());
        }
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
