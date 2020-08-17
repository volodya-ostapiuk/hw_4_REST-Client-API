package com.epam.entity.author;

public class NameEntity {
    private String first;

    private String second;

    public NameEntity() {
    }

    public NameEntity(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirstName(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecondName(String second) {
        this.second = second;
    }
}
