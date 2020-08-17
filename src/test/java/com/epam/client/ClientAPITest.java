package com.epam.client;

import com.epam.TestFields;
import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;
import com.epam.utils.EntitiesArray;
import com.epam.utils.IdChecker;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.ClientResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientAPITest extends TestFields {

    @Test(groups = "positive")
    public void getGenresArray() {
        GenreEntity[] genres = EntitiesArray.getAllGenres();
        Assert.assertNotNull(genres, "Array is empty");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
    }

    @Test(groups = "positive")
    public void getGenreById() {
        randomID = IdChecker.getPresentGenreId();
        clientResponse = clientAPI.doGet(String.format("%s/%s/%d", url, genreName, randomID), type);
        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(genreEntity.getGenreId(), randomID, "You're taking wrong genreId");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
    }

    @Test(groups = "negative", description = "get genre by id that does not exist")
    public void getGenreByWrongId() {
        randomID = IdChecker.getAbsentGenreId();
        clientResponse = clientAPI.doGet(String.format("%s/%s/%d", url, genreName, randomID), type);
        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertNotEquals(genreEntity.getGenreId(), randomID, "You're taking existed genreId");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_NOT_FOUND, "Response is supposed to be 404");
    }

    @Test(groups = "positive")
    public void getGenreBySize() {
        int size = 13;
        clientResponse = clientAPI.doGet(String.format("%s/%s?%s=%d", url, genresName, sizeCriteria, size), type);
        GenreEntity[] genres = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity[].class);
        Assert.assertNotNull(genres, "Array is empty");
        Assert.assertEquals(genres.length, size,"Array is not queried right");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
    }

    @Test(groups = "positive")
    public void addNewGenre() throws JsonProcessingException {
        randomID = IdChecker.getAbsentGenreId();
        GenreEntity genreEntity = new GenreEntity(randomID, randomGenreName + randomID,
                randomGenreDescription);
        clientResponse = clientAPI.doPostGenre(String.format("%s/%s", url, genreName), type, genreEntity);
        GenreEntity genre = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_CREATED_SUCCESS, "Response is not OK");
        Assert.assertEquals(genre.getGenreId(), randomID, "Posted ID is not equal");
        Assert.assertEquals(genre.getGenreDescription(), randomGenreDescription,
                "Posted Genre Description is not equal");
    }

    @Test(groups = "negative", description = "delete genre that does not exist")
    public void deleteNotExistedGenre() {
        randomID = IdChecker.getAbsentGenreId();
        int sizeBeforeDelete = EntitiesArray.getAllGenres().length;
        ClientResponse response = clientAPI.doDelete(String.format("%s/%s/%d", url, genreName, randomID), type);
        int sizeAfterDelete = EntitiesArray.getAllGenres().length;
        Assert.assertEquals(sizeAfterDelete, sizeBeforeDelete, "You're deleting existed genreId");
        Assert.assertEquals(response.getStatus(), HTTP_NOT_FOUND, "Response is supposed to be 404");
    }

    @Test(groups = "positive")
    public void updateExistingGenre() throws JsonProcessingException {
        randomID = IdChecker.getPresentGenreId();
        clientResponse = clientAPI.doGet(String.format("%s/%s/%d", url, genreName, randomID), type);
        GenreEntity genreEntity = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        GenreEntity genreUpdated = new GenreEntity(randomID, randomGenreName + randomID,
                randomGenreDescription);
        clientResponse = clientAPI.doPutGenre(String.format("%s/%s", url, genreName), type, genreUpdated);
        GenreEntity genre = gson.fromJson(clientResponse.getEntity(String.class), GenreEntity.class);
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
        Assert.assertEquals(genre.getGenreId(), genreEntity.getGenreId(), "Updated ID is not equal");
        Assert.assertNotEquals(genre.getGenreName(), genreEntity.getGenreName(), "Updated Names are equal");
    }

    @Test(groups = "positive")
    public void getAuthorsArray() {
        AuthorEntity[] authors = EntitiesArray.getAllAuthors();
        Assert.assertNotNull(authors, "Array is empty");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
    }

    @Test(groups = "positive")
    public void getBooksArray() {
        BookEntity[] books = EntitiesArray.getAllBooks();
        Assert.assertNotNull(books, "Array is empty");
        Assert.assertEquals(clientResponse.getStatus(), HTTP_SUCCESS, "Response is not OK");
    }
}
