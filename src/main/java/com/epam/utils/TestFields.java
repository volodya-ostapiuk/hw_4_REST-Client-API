package com.epam.utils;

import com.epam.client.ClientAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.ClientResponse;

public class TestFields {
    public static ClientAPI clientAPI = new ClientAPI();
    protected static String url = "http://localhost:8080/api/library";
    protected static String jsonAppType = "application/json";
    protected static Gson gson = new GsonBuilder().create();
    protected static ClientResponse clientResponse;
    protected static final int HTTP_SUCCESS = 200;
    protected static final int HTTP_CREATED_SUCCESS = 201;
    protected static final int HTTP_NOT_FOUND = 404;
    protected static String genresEndpoint = "genres";
    protected static String authorsEndpoint = "authors";
    protected static String booksEndpoint = "books";
    protected static String genreEndpoint = "genre";
    protected static String authorEndpoint = "author";
    protected static String bookEndpoint = "book";
    protected static String sizeCriteria = "size";
    protected static int randomID;
    protected static final int MINIMUM = 0;
    protected static String randomGenreName = "Biography";
    protected static String randomGenreDescription = "Story about someone's life path";
    protected static String randomAuthorFirstName = "Volodymyr";
    protected static String randomAuthorSecondName = "Ostapiuk";
    protected static String randomAuthorNationality = "Ukrainian";
    protected static String randomAuthorDescription = "This is a beginner";
    protected static String randomAuthorDate = "1908-11-11";
    protected static String randomAuthorCountry = "Ukraine";
    protected static String randomAuthorCity = "Lviv";
}
