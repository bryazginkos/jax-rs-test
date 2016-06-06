package ru.kosdev.train.jaxrs.controller.dto;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface PageDto<T> {

    List<T> getData();

    int getPageNum();

    int getTotal();

    boolean isHasNext();

    boolean isHasPrevious();
}
