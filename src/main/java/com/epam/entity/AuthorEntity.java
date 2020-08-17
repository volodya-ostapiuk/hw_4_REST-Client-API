package com.epam.entity;

import com.epam.entity.author.BirthEntity;
import com.epam.entity.author.NameEntity;

public class AuthorEntity {
    private int authorId;

    private NameEntity authorName;

    private String authorDescription;

    private String nationality;

   private BirthEntity birth;

    public AuthorEntity() {
    }

    public AuthorEntity(int authorId, NameEntity authorName, String authorDescription,
                        String nationality, BirthEntity birth) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorDescription = authorDescription;
        this.nationality = nationality;
        this.birth = birth;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public NameEntity getAuthorName() {
        return authorName;
    }

    public void setAuthorName(NameEntity authorName) {
        this.authorName = authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public BirthEntity getBirth() {
        return birth;
    }

    public void setBirth(BirthEntity birth) {
        this.birth = birth;
    }
}
