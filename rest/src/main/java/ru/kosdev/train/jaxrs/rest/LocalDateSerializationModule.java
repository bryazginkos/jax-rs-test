package ru.kosdev.train.jaxrs.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by kbryazgin on 5/19/2016.
 */
public class LocalDateSerializationModule extends SimpleModule {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public LocalDateSerializationModule() {
        super("LocalDateSerializationModule");
        addSerializer(LocalDate.class, new LocalDateSerializer());
        addDeserializer(LocalDate.class, new LocalDateDeserializer());
    }

    /**
     * LocalDateSerializer.
     */
    static class LocalDateSerializer extends JsonSerializer<LocalDate> {
        @Override
        public void serialize(final LocalDate localDate, final JsonGenerator jsonGenerator,
                              final SerializerProvider serializerProvider)
                throws IOException {
            jsonGenerator.writeString(localDate.format(FORMATTER));
        }
    }

    /**
     * LocalDateDeserializer.
     */
     static class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(final JsonParser jsonParser,
                                     final DeserializationContext deserializationContext)
                throws IOException {
            final String valueAsString = jsonParser.getValueAsString();
            return LocalDate.parse(valueAsString, FORMATTER);
        }
    }
}
