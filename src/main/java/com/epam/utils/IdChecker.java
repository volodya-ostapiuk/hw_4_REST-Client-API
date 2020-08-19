package com.epam.utils;

import com.epam.entity.AuthorEntity;
import com.epam.entity.BookEntity;
import com.epam.entity.GenreEntity;

import java.util.Random;

public class IdChecker extends TestFields {
    public static boolean check;

    public static int getPresentGenreId() {
        check = false;
        GenreEntity[] genres = AllEntitiesGetter.getAllGenres();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (GenreEntity genre : genres) {
                if (randomID == genre.getGenreId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentGenreId(){
        check = false;
        GenreEntity[] genres = AllEntitiesGetter.getAllGenres();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (GenreEntity genre : genres) {
                if (randomID == genre.getGenreId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getPresentAuthorId() {
        check = false;
        AuthorEntity[] authors = AllEntitiesGetter.getAllAuthors();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (AuthorEntity author : authors) {
                if (randomID == author.getAuthorId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentAuthorId(){
        check = false;
        AuthorEntity[] authors = AllEntitiesGetter.getAllAuthors();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (AuthorEntity author : authors) {
                if (randomID == author.getAuthorId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getPresentBookId() {
        check = false;
        BookEntity[] books = AllEntitiesGetter.getAllBooks();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (BookEntity book : books) {
                if (randomID == book.getBookId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentBookId(){
        check = false;
        BookEntity[] books = AllEntitiesGetter.getAllBooks();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (BookEntity book : books) {
                if (randomID == book.getBookId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }
}
