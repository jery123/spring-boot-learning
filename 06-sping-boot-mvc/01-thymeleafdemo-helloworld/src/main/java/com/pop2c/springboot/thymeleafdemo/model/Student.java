package com.pop2c.springboot.thymeleafdemo.model;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;

    public Student() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry(){
        return this.country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getFavoriteLanguage(){
        return this.favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage){
        this.favoriteLanguage = favoriteLanguage;
    }
}
