package ru.kosdev.train.jaxrs.controller.converters.fromdto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Component
public class GroupConverterFromDto implements Function<GroupDto, Group> {

    @Override
    public Group apply(final GroupDto groupDto) {
        if (groupDto == null) {
            return null;
        }
        final Group group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        return group;
    }

}
