package ru.kosdev.train.jaxrs.service.converters.fromdto;

import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.service.api.dto.GroupDto;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import java.util.function.Function;

/**
 * Created by kos on 07.05.16.
 */
@Service
public class GroupConverterFromDto implements Function<GroupDto, Group> {

    @Override
    public Group apply(GroupDto groupDto) {
        if (groupDto == null) {
            return null;
        }
        Group group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        return group;
    }

}
