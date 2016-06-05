package ru.kosdev.train.jaxrs.controller.api;

import ru.kosdev.train.jaxrs.controller.dto.GroupDto;
import ru.kosdev.train.jaxrs.controller.dto.PageDto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by kos on 04.06.16.
 */
public interface GroupController {

    @Nonnull
    GroupDto createGroup(@Nonnull GroupDto groupDto);

    @Nonnull
    GroupDto updateGroup(@Nonnull Integer id, @Nonnull GroupDto groupDto);

    void deteteGroup(@Nonnull Integer groupId);

    @Nonnull
    PageDto<GroupDto> getGroups(@Nonnull Integer page, @Nonnull Integer pageSize);

    @Nonnull
    GroupDto getGroup(@Nonnull Integer groupId);
}
