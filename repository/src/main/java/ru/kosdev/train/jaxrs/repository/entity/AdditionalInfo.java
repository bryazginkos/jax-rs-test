package ru.kosdev.train.jaxrs.repository.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by kos on 07.05.16.
 */
@Embeddable
public class AdditionalInfo implements Serializable {

    private LocalDate dateValue;

    private String urlValue;

    private String textValue;

    private Integer intValue;

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
