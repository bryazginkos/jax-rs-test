package ru.kosdev.train.jaxrs.controller.dto;

import java.util.List;

/**
 * Created by kos on 04.06.16.
 */
public interface PageDto<T> {

    List<T> getData();

    int getPageNum();

    int getTotal();

    boolean isHasNext();

    boolean isHasPrevious();
}
