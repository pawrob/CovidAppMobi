package com.example.covidbook.info;

public class PersosInfo {
    private int temperature;
    private float rating;
    private int peaoplePassed;
    private String goOut;
    private String notes;

    public PersosInfo(int temperature, float rating, int peaoplePassed, String goOut, String notes) {
        this.temperature = temperature;
        this.rating = rating;
        this.peaoplePassed = peaoplePassed;
        this.goOut = goOut;
        this.notes = notes;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPeaoplePassed() {
        return peaoplePassed;
    }

    public void setPeaoplePassed(int peaoplePassed) {
        this.peaoplePassed = peaoplePassed;
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
                ", peaoplePassed=" + peaoplePassed +
                ", goOut='" + goOut + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
