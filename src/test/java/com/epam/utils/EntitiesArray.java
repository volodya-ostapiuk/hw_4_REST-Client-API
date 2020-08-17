package com.epam.utils;

import com.epam.TestFields;
import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;

public class EntitiesArray extends TestFields {
    public static GenreEntity[] getAllGenres() {
        clientResponse = clientAPI.doGet(String.format("%s/%s", url, genresName), type);
        return gson.fromJson(clientResponse.getEntity(String.class), GenreEntity[].class);
    }

    public static AuthorEntity[] getAllAuthors() {
        clientResponse = clientAPI.doGet(String.format("%s/%s", url, authorsName), type);
        return gson.fromJson(clientResponse.getEntity(String.class), AuthorEntity[].class);
    }

    public static BookEntity[] getAllBooks() {
        clientResponse = clientAPI.doGet(String.format("%s/%s", url, booksName), type);
        return gson.fromJson(clientResponse.getEntity(String.class), BookEntity[].class);
    }
}
