package ru.kosdev.train.jaxrs.controller.converters.todto;

import org.springframework.stereotype.Component;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Component
public class GroupConverterToDto implements Function<Group, GroupDto> {
    @Override
    public GroupDto apply(final Group group) {
        if (group == null) {
            return null;
        }
        final GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        return groupDto;
    }
}
