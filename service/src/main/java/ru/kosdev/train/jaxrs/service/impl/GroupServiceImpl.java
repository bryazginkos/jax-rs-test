package ru.kosdev.train.jaxrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kosdev.train.jaxrs.repository.dao.GroupRepository;
import ru.kosdev.train.jaxrs.repository.entity.Group;
import ru.kosdev.train.jaxrs.service.api.GroupService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by kos on 04.06.16.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Nonnull
    @Override
    public Group createGroup(@Nonnull final Group group) {
        group.setId(null);
        return groupRepository.save(group);
    }

    @Nonnull
    @Override
    public Group updateGroup(@Nonnull final Integer groupId, @Nonnull final Group group) {
        group.setId(groupId);
        return groupRepository.save(group);
    }

    @Nonnull
    @Override
    public Page<Group> getGroups(@Nonnull final Integer page, @Nonnull final Integer pageSize) {
        return groupRepository.findAll(new PageRequest(page, pageSize));
    }

    @Nullable
    @Override
    public Group getGroup(@Nonnull final Integer groupId) {
        return groupRepository.findOne(groupId);
    }

    @Override
    public boolean checkGroupNameIsFree(@Nonnull final String name) {
        final Group sameNameGroup = groupRepository.findByName(name);
        return sameNameGroup == null;
    }

    @Override
    public boolean checkGroupNameHasOnly(@Nonnull final Integer groupId, @Nonnull final String name) {
        final Group sameNameGroup = groupRepository.findByName(name);
        return sameNameGroup == null || groupId.equals(sameNameGroup.getId());
    }

    @Override
    public boolean exists(@Nonnull final Integer groupId) {
        return getGroup(groupId) != null;
    }

    @Override
    public void deleteGroup(@Nonnull final Integer id) {
        groupRepository.delete(id);
    }
}
