package com.epam.entity.book;

public class AdditionalEntity {
    private Integer pageCount;

    private SizeEntity size;

    public AdditionalEntity() {
    }

    public AdditionalEntity(Integer pageCount, SizeEntity size) {
        this.pageCount = pageCount;
        this.size = size;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }
}
