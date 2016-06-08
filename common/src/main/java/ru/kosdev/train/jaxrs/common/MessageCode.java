package ru.kosdev.train.jaxrs.common;

/**
 * Created by kos on 06.06.16.
 */
public enum MessageCode {

    ERR_CONTACT_NOT_FOUND("err.contact.not.found"),
    ERR_CONTACT_NAME_USED("err.contact.name.used"),

    ERR_GROUP_NOT_FOUND("err.group.not.found"),
    ERR_GROUP_NAME_USED("err.group.name.used"),
    ERR_UNKNOWN("err.unknown");

    private final String key;

    MessageCode(final String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
