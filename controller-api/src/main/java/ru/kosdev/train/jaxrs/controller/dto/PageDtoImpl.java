package ru.kosdev.train.jaxrs.controller.dto;

import java.util.List;

/**
 *
 * @param <T>
 */
public class PageDtoImpl<T> implements PageDto<T> {
    private List<T> data;

    private int pageNum;

    private int total;

    private boolean hasNext;

    private boolean hasPrevious;

    @Override
    public List<T> getData() {
        return data;
    }

    public void setData(final List<T> data) {
        this.data = data;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(final int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getTotal() {
        return total;
    }

    public void setTotal(final int total) {
        this.total = total;
    }

    @Override
    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(final boolean hasNext) {
        this.hasNext = hasNext;
    }

    @Override
    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(final boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }
}
