package com.epam.client;

import com.epam.utils.TestEntityGetter;
import com.epam.utils.TestFields;
import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;
import com.epam.utils.AllEntitiesGetter;
import com.epam.utils.IdChecker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientAPITest extends TestFields {

    @Test(groups = "positive", description = "get genre array")
    public void getGenresArray() {
        GenreEntity[] genres = AllEntitiesGetter.getAllGenres();
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        Assert.assertNotNull(genres, "Array is empty");
    }

    @Test(groups = "positive", description = "get genre by existing id")
    public void getGenreById() {
        randomID = IdChecker.getPresentGenreId();
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s/%d", genreEndpoint, randomID), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(genreEntity.getGenreId(), randomID, "You're taking wrong genreId");
    }

    @Test(groups = "negative", description = "get genre by id that does not exist")
    public void getGenreByWrongId() {
        randomID = IdChecker.getAbsentGenreId();
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s/%d", genreEndpoint, randomID), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_NOT_FOUND, "Response is supposed to be 404");
        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertNotEquals(genreEntity.getGenreId(), randomID, "You're taking existed genreId");
    }

    @Test(groups = "positive")
    public void getGenreBySize() {
        int searchQuerySize = 13;
        clientResponse = clientAPI.doGet(String.format(
                "http://localhost:8080/api/library/%s?%s=%d", genresEndpoint, sizeCriteria, searchQuerySize), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        GenreEntity[] genres = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity[].class);
        Assert.assertNotNull(genres, "Array is empty");
        Assert.assertEquals(genres.length, searchQuerySize,"Array is not queried right");
    }

    @Test(groups = "positive", description = "add new genre with not existing id")
    public void addNewGenre() throws JsonProcessingException {
        randomID = IdChecker.getAbsentGenreId();
        GenreEntity genreEntity = TestEntityGetter.getTestGenreEntity(randomID);
        clientResponse = clientAPI.doPostGenre(
                String.format("http://localhost:8080/api/library/%s", genreEndpoint), jsonAppType, genreEntity);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_CREATED_SUCCESS, "Response is not OK");
        GenreEntity genre = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(genre.getGenreId(), randomID, "Posted ID is not equal");
        Assert.assertEquals(genre.getGenreDescription(), randomGenreDescription,
                "Posted Genre Description is not equal");
    }

    @Test(groups = "negative", description = "delete genre that does not exist")
    public void deleteNotExistedGenre() {
        randomID = IdChecker.getAbsentGenreId();
        int sizeBeforeDelete = AllEntitiesGetter.getAllGenres().length;
        ClientResponse response = clientAPI.doDelete(
                String.format("http://localhost:8080/api/library/%s/%d", genreEndpoint, randomID), jsonAppType);
        Assert.assertEquals(response.getStatus(), HTTP_NOT_FOUND, "Response is supposed to be 404");
        int sizeAfterDelete = AllEntitiesGetter.getAllGenres().length;
        Assert.assertEquals(sizeAfterDelete, sizeBeforeDelete, "You're deleting existed genreId");
    }

    @Test(groups = "positive", description = "update genre with existing id")
    public void updateExistingGenre() throws JsonProcessingException {
        randomID = IdChecker.getPresentGenreId();
        clientResponse = clientAPI.doGet(
                String.format("http://localhost:8080/api/library/%s/%d", genreEndpoint, randomID), jsonAppType);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");

        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        GenreEntity genreUpdated = TestEntityGetter.getTestGenreEntity(randomID);
        clientResponse = clientAPI.doPutGenre(
                String.format("http://localhost:8080/api/library/%s", genreEndpoint), jsonAppType, genreUpdated);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");

        GenreEntity genre = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(genre.getGenreId(), genreEntity.getGenreId(), "Updated ID is not equal");
        Assert.assertNotEquals(genre.getGenreName(), genreEntity.getGenreName(), "Updated Names are equal");
    }

    @Test(groups = "positive", description = "get author array")
    public void getAuthorsArray() {
        AuthorEntity[] authors = AllEntitiesGetter.getAllAuthors();
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        Assert.assertNotNull(authors, "Array is empty");
    }

    @Test(groups = "positive", description = "get book array")
    public void getBooksArray() {
        BookEntity[] books = AllEntitiesGetter.getAllBooks();
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        Assert.assertNotNull(books, "Array is empty");
    }
}
