package com.epam.client;

import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.UriBuilder;

public class ClientAPI {
    private Client client;
    private WebResource webResource;

    public ClientAPI() {
        client = Client.create();
    }

    public ClientResponse doGet(String uri, String type) {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        return webResource
                .type(type)
                .get(ClientResponse.class);
    }

    public ClientResponse doPostGenre(String uri, String type, GenreEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .post(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doPostAuthor(String uri, String type, AuthorEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .post(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doPostBook(String uri, String type, BookEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .post(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doPutGenre(String uri, String type, GenreEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .put(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doPutAuthor(String uri, String type, AuthorEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .put(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doPutBook(String uri, String type, BookEntity entity) throws JsonProcessingException {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        ObjectMapper mapper = new ObjectMapper();
        return webResource
                .type(type)
                .put(ClientResponse.class, mapper.writeValueAsString(entity));
    }

    public ClientResponse doDelete(String uri, String type) {
        webResource = client.resource(UriBuilder.fromUri(uri).build());
        return webResource
                .type(type)
                .delete(ClientResponse.class);
    }
}
