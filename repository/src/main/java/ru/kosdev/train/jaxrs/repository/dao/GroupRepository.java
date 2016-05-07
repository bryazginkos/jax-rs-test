package ru.kosdev.train.jaxrs.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kosdev.train.jaxrs.repository.entity.Group;

/**
 * Created by kos on 07.05.16.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Integer> {
}
