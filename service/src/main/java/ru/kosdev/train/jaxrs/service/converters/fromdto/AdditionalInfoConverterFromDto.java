package ru.kosdev.train.jaxrs.service.converters.fromdto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class AdditionalInfoConverterFromDto implements Function<AdditionalInfoDto, AdditionalInfo> {
    @Override
    public AdditionalInfo apply(final AdditionalInfoDto additionalInfoDto) {
        if (additionalInfoDto == null) {
            return null;
        }
        final AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setUrlValue(additionalInfoDto.getUrlValue());
        additionalInfo.setTextValue(additionalInfoDto.getTextValue());
        additionalInfo.setIntValue(additionalInfoDto.getIntValue());
        additionalInfo.setEmailValue(additionalInfoDto.getEmailValue());
        final Date dateValue = additionalInfoDto.getDateValue();
        if (dateValue != null) {
            final Instant instant = Instant.ofEpochMilli(dateValue.getTime());
            final LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            additionalInfo.setDateValue(localDate);
        }
        return additionalInfo;
    }
}
