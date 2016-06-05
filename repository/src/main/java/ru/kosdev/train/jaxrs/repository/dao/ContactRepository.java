package ru.kosdev.train.jaxrs.repository.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kosdev.train.jaxrs.repository.entity.Contact;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by kos on 07.05.16.
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    @Nonnull
    Page<Contact> findAll(@Nonnull Pageable pageable);

    @Nullable
    Contact findByName(@Nonnull String name);
}
