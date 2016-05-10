package ru.kosdev.train.jaxrs.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kosdev.train.jaxrs.repository.entity.Group;

/**
 * Created by kbryazgin on 5/10/2016.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {
}
