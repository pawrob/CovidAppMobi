package com.example.covidbook.info;

import com.google.gson.annotations.SerializedName;

public class PersonInfo {
    @SerializedName("temperature")
    private float temperature;
    @SerializedName("rating")
    private float rating;
    @SerializedName("peoplePassed")
    private int peoplePassed;
    @SerializedName("goOut")
    private String goOut;
    @SerializedName("notes")
    private String notes;

    public PersonInfo(float temperature, float rating, int peoplePassed, String goOut, String notes) {
        this.temperature = temperature;
        this.rating = rating;
        this.peoplePassed = peoplePassed;
        this.goOut = goOut;
        this.notes = notes;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPeoplePassed() {
        return peoplePassed;
    }

    public void setPeoplePassed(int peoplePassed) {
        this.peoplePassed = peoplePassed;
    }

    public String getGoOut() {
        return goOut;
    }

    public void setGoOut(String goOut) {
        this.goOut = goOut;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "PersosInfo{" +
                "temperature=" + temperature +
                ", rating=" + rating +
                ", peaoplePassed=" + peoplePassed +
                ", goOut='" + goOut + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
