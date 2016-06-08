package ru.kosdev.train.jaxrs.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kosdev.train.jaxrs.controller.api.GroupController;
import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;
import ru.kosdev.train.jaxrs.rest.api.GroupResource;


/**
 * Created by kos on 04.06.16.
 */
@Controller
public class GroupResourceImpl implements GroupResource {

    @Autowired
    private GroupController groupController;

    @Override
    public GroupDto create(final GroupDto groupDto) {
        return groupController.createGroup(groupDto);
    }

    @Override
    public GroupDto update(final Integer groupId, final GroupDto contactDto) {
        return groupController.updateGroup(groupId, contactDto);
    }

    @Override
    public GroupDto getGroup(final Integer groupId) {
        return groupController.getGroup(groupId);
    }

    @Override
    public void deleteGroup(final Integer groupId) {
        groupController.deteteGroup(groupId);
    }

    @Override
    public PageDto<GroupDto> getGroups(final Integer page, final Integer size) {
        return groupController.getGroups(page, size);
    }
}
