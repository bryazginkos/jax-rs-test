package ru.kosdev.train.jaxrs.service.converters.todto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class AdditionalInfoConverterToDto implements Function<AdditionalInfo, AdditionalInfoDto> {
    @Override
    public AdditionalInfoDto apply(AdditionalInfo additionalInfo) {
        if (additionalInfo == null) {
            return null;
        }
        AdditionalInfoDto additionalInfoDto = new AdditionalInfoDto();
        additionalInfoDto.setUrlValue(additionalInfo.getUrlValue());
        additionalInfoDto.setTextValue(additionalInfo.getTextValue());
        additionalInfoDto.setIntValue(additionalInfo.getIntValue());
        additionalInfoDto.setEmailValue(additionalInfo.getEmailValue());
        additionalInfoDto.setDateValue(additionalInfo.getDateValue());
        return additionalInfoDto;
    }
}