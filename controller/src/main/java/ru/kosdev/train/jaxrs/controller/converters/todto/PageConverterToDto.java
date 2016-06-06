package ru.kosdev.train.jaxrs.controller.converters.todto;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDtoImpl;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kos on 04.06.16.
 */
@Component
public class PageConverterToDto {

    @Nonnull
    public <DTO, ENTITY> PageDto<DTO> convert(@Nonnull final Page<ENTITY> page,
                                              @Nonnull final Function<ENTITY, DTO> function) {
        final PageDtoImpl<DTO> pageDto = new PageDtoImpl<>();
        pageDto.setHasNext(page.hasNext());
        pageDto.setHasPrevious(page.hasPrevious());
        pageDto.setPageNum(page.getNumber());
        pageDto.setTotal((int) page.getTotalElements());
        final List<ENTITY> content = page.getContent();
        if (content != null) {
            final List<DTO> dtoList = content.stream()
                    .map(function)
                    .collect(Collectors.toList());
            pageDto.setData(dtoList);
        }
        return pageDto;
    }
}
