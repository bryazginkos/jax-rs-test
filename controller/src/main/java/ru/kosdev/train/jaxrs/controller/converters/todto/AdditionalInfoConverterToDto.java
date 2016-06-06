package ru.kosdev.train.jaxrs.controller.converters.todto;

import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Component
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
        additionalInfoDto.setDateValue(additionalInfo.getDateValue());
        return additionalInfoDto;
    }
}
