package com.epam.entity;

import com.epam.entity.book.AdditionalEntity;

public class BookEntity {
    private int bookId;

    private String bookName;

    private String bookLanguage;

    private String bookDescription;

    private AdditionalEntity additional;

    private Integer publicationYear;

    public BookEntity() {
    }

    public BookEntity(int bookId, String bookName, String bookLanguage, String bookDescription,
                      AdditionalEntity additional, Integer publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.additional = additional;
        this.publicationYear = publicationYear;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public AdditionalEntity getAdditional() {
        return additional;
    }

    public void setAdditional(AdditionalEntity additional) {
        this.additional = additional;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}
