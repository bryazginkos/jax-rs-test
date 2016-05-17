package ru.kosdev.train.jaxrs.service.converters.todto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class AdditionalInfoConverterToDto implements Function<AdditionalInfo, AdditionalInfoDto> {
    @Override
    public AdditionalInfoDto apply(final AdditionalInfo additionalInfo) {
        if (additionalInfo == null) {
            return null;
        }
        final AdditionalInfoDto additionalInfoDto = new AdditionalInfoDto();
        additionalInfoDto.setUrlValue(additionalInfo.getUrlValue());
        additionalInfoDto.setTextValue(additionalInfo.getTextValue());
        additionalInfoDto.setIntValue(additionalInfo.getIntValue());
        additionalInfoDto.setEmailValue(additionalInfo.getEmailValue());
        final LocalDate localDate = additionalInfo.getDateValue();
        if (localDate != null) {
            final Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            final Date date = Date.from(instant);
            additionalInfoDto.setDateValue(date);
        }
        return additionalInfoDto;
    }
}
