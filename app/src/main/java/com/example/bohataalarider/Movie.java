package com.example.bohataalarider;

public class Movie {
    private String title, genre, year;
private String oid;
private String tid;
    public Movie() {
    }

    public Movie(String title, String genre, String year,String oid,String tid) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.oid = oid;
        this.tid = tid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
