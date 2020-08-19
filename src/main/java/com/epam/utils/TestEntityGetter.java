package com.epam.utils;

import com.epam.entity.AuthorEntity;
import com.epam.entity.GenreEntity;
import com.epam.entity.author.BirthEntity;
import com.epam.entity.author.NameEntity;

public class TestEntityGetter extends TestFields {
    public static GenreEntity getTestGenreEntity(int randomID) {
        GenreEntity testEntity = new GenreEntity();
        testEntity.setGenreId(randomID);
        testEntity.setGenreName(randomGenreName + randomID);
        testEntity.setGenreDescription(randomGenreDescription);
        return testEntity;
    }

    public static AuthorEntity getTestAuthorEntity(int randomID) {
        AuthorEntity testEntity = new AuthorEntity();
        testEntity.setAuthorId(randomID);
        testEntity.setAuthorName(getTestNameEntity());
        testEntity.setNationality(randomAuthorNationality);
        testEntity.setAuthorDescription(randomAuthorDescription);
        testEntity.setBirth(getTestBirthEntity());
        return testEntity;
    }

    private static NameEntity getTestNameEntity() {
        NameEntity nameEntity = new NameEntity();
        nameEntity.setFirstName(randomAuthorFirstName + randomID);
        nameEntity.setSecondName(randomAuthorSecondName);
        return nameEntity;
    }

    private static BirthEntity getTestBirthEntity() {
        BirthEntity birthEntity = new BirthEntity();
        birthEntity.setDate(randomAuthorDate);
        birthEntity.setCountry(randomAuthorCountry);
        birthEntity.setCity(randomAuthorCity);
        return birthEntity;
    }
}
