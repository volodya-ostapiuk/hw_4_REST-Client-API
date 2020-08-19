package com.epam.utils;

import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;
import org.testng.Assert;

public class AllEntitiesGetter extends TestFields {
    public static GenreEntity[] getAllGenres() {
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s", genresEndpoint), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        return gson.fromJson(clientResponse.getEntity(String.class), GenreEntity[].class);
    }

    public static AuthorEntity[] getAllAuthors() {
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s", authorsEndpoint), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        return gson.fromJson(clientResponse.getEntity(String.class), AuthorEntity[].class);
    }

    public static BookEntity[] getAllBooks() {
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s", booksEndpoint), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        return gson.fromJson(clientResponse.getEntity(String.class), BookEntity[].class);
    }
}
