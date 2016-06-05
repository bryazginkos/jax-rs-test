package ru.kosdev.train.jaxrs.controller.converters.fromdto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.controller.dto.AdditionalInfoDto;
import ru.kosdev.train.jaxrs.repository.entity.AdditionalInfo;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Component
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
        additionalInfo.setDateValue(additionalInfoDto.getDateValue());

        return additionalInfo;
    }
}
