package ru.kosdev.train.jaxrs.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import ru.kosdev.train.jaxrs.controller.api.GroupController;
import ru.kosdev.train.jaxrs.controller.api.IncorrectDataException;
import ru.kosdev.train.jaxrs.controller.api.NotFoundException;
import ru.kosdev.train.jaxrs.controller.converters.fromdto.GroupConverterFromDto;
import ru.kosdev.train.jaxrs.controller.converters.todto.GroupConverterToDto;
import ru.kosdev.train.jaxrs.controller.converters.todto.PageConverterToDto;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;
import ru.kosdev.train.jaxrs.repository.entity.Group;
import ru.kosdev.train.jaxrs.service.api.GroupService;

import javax.annotation.Nonnull;

/**
 * Created by kos on 04.06.16.
 */
@Controller
@Transactional
public class GroupControllerImpl implements GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupConverterToDto toDtoConverter;

    @Autowired
    private GroupConverterFromDto fromDtoConverter;

    @Autowired
    private PageConverterToDto pageConverterToDto;

    @Override
    @Nonnull
    public GroupDto createGroup(@Nonnull GroupDto groupDto) {
        final String name = groupDto.getName();
        final boolean validName = groupService.checkGroupNameIsFree(name);
        if (!validName) {
            throw new IncorrectDataException("Name " + name + " is already used");
        }
        final Group group = fromDtoConverter.apply(groupDto);
        final Group createdGroup = groupService.createGroup(group);
        return toDtoConverter.apply(createdGroup);
    }

    @Override
    @Nonnull
    public GroupDto updateGroup(@Nonnull Integer id, @Nonnull GroupDto groupDto) {
        checkGroupExists(id);
        final String name = groupDto.getName();
        final boolean validName = groupService.checkGroupNameHasOnly(id, name);
        if (!validName) {
            throw new IncorrectDataException("Name " + name + " is already used");
        }
        final Group group = fromDtoConverter.apply(groupDto);
        final Group updatedGroup = groupService.updateGroup(id, group);
        return toDtoConverter.apply(updatedGroup);
    }

    @Override
    public void deteteGroup(@Nonnull Integer groupId) {
        checkGroupExists(groupId);
        groupService.deleteGroup(groupId);
    }

    @Override
    public PageDto<GroupDto> getGroups(@Nonnull Integer page, @Nonnull Integer pageSize) {
        final Page<Group> groups = groupService.getGroups(page, pageSize);
        return pageConverterToDto.convert(groups, toDtoConverter);
    }

    @Override
    @Nonnull
    public GroupDto getGroup(@Nonnull Integer groupId) {
        checkGroupExists(groupId);
        final Group group = groupService.getGroup(groupId);
        return toDtoConverter.apply(group);
    }

    private void checkGroupExists(@Nonnull Integer groupId) {
        if (!groupService.exists(groupId)) {
            throw new NotFoundException("Group with id " + groupId + " doesn't exist");
        }
    }
}
