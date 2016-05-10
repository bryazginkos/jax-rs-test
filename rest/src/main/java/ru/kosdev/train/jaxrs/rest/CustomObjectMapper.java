package ru.kosdev.train.jaxrs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

/**
 * Created by kbryazgin on 5/10/2016.
 */
public class CustomObjectMapper extends ObjectMapper {

    private static final String DATE_TIME_FORMAT = "dd.MM.yyyy";

    public CustomObjectMapper() {
        setDateFormat(new SimpleDateFormat(DATE_TIME_FORMAT));
    }
}
