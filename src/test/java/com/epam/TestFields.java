package com.epam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse;

public class TestFields {
    public static ClientAPI clientAPI = new ClientAPI();
    protected static String url = "http://localhost:8080/api/library";
    protected static String type = "application/json";
    protected static Gson gson = new GsonBuilder().create();
    protected static ClientResponse clientResponse;
    protected static final int HTTP_SUCCESS = 200;
    protected static final int HTTP_CREATED_SUCCESS = 201;
    protected static final int HTTP_NOT_FOUND = 404;
    protected static String genresName = "genres";
    protected static String authorsName = "authors";
    protected static String booksName = "books";
    protected static String genreName = "genre";
    protected static String authorName = "author";
    protected static String bookName = "book";
    protected static String sizeCriteria = "size";
    protected static int randomID;
    protected static final int MINIMUM = 0;
    protected static String randomGenreName = "Biography";
    protected static String randomGenreDescription = "Story about someone's life path";
}
