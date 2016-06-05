package ru.kosdev.train.jaxrs.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kosdev.train.jaxrs.repository.entity.Group;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by kbryazgin on 5/10/2016.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {

    @Nonnull
    Page<Group> findAll(@Nonnull Pageable pageable);

    @Nullable
    Group findByName(@Nonnull String name);
}
