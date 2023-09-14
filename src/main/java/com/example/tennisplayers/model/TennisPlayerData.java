package com.example.tennisplayers.model;

public class TennisPlayerData {

    private int id;
    private String firstname;
    private String lastname;
    private String shortname;
    private String sex;
    private TennisPlayerCountryData country;
    private String picture;
    private TennisPlayerDataData data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public TennisPlayerCountryData getCountry() {
        return country;
    }

    public void setCountry(TennisPlayerCountryData country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public TennisPlayerDataData getData() {
        return data;
    }

    public void setData(TennisPlayerDataData data) {
        this.data = data;
    }
}
