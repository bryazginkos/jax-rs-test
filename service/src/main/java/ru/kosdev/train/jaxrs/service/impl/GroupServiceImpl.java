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
    public Group createGroup(@Nonnull Group group) {
        group.setId(null);
        return groupRepository.save(group);
    }

    @Nonnull
    @Override
    public Group updateGroup(@Nonnull Integer groupId, @Nonnull Group group) {
        group.setId(groupId);
        return groupRepository.save(group);
    }

    @Nonnull
    @Override
    public Page<Group> getGroups(@Nonnull Integer page, @Nonnull Integer pageSize) {
        return groupRepository.findAll(new PageRequest(page, pageSize));
    }

    @Nullable
    @Override
    public Group getGroup(@Nonnull Integer groupId) {
        return groupRepository.findOne(groupId);
    }

    @Override
    public boolean checkGroupNameIsFree(@Nonnull String name) {
        final Group sameNameGroup = groupRepository.findByName(name);
        return sameNameGroup == null;
    }

    @Override
    public boolean checkGroupNameHasOnly(@Nonnull Integer groupId, @Nonnull String name) {
        final Group sameNameGroup = groupRepository.findByName(name);
        return sameNameGroup == null || groupId.equals(sameNameGroup.getId());
    }

    @Override
    public boolean exists(@Nonnull Integer groupId) {
        return getGroup(groupId) != null;
    }

    @Override
    public void deleteGroup(@Nonnull Integer id) {
        groupRepository.delete(id);
    }
}
