package ru.kosdev.train.jaxrs.service.api;

import org.springframework.data.domain.Page;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by kos on 04.06.16.
 */
public interface GroupService {

    @Nonnull
    Group createGroup(@Nonnull Group group);

    @Nonnull
    Group updateGroup(@Nonnull Integer groupId, @Nonnull Group group);

    @Nonnull
    Page<Group> getGroups(@Nonnull Integer page, @Nonnull Integer pageSize);

    @Nullable
    Group getGroup(@Nonnull Integer groupId);

    boolean checkGroupNameIsFree(@Nonnull String name);

    boolean checkGroupNameHasOnly(@Nonnull Integer groupId, @Nonnull String name);

    boolean exists(@Nonnull Integer groupId);

    void deleteGroup(@Nonnull Integer id);
}
