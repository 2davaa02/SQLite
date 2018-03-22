package com.example.a2davaa02.sqlite;

/**
 * Created by 2davaa02 on 21/03/2018.
 */

public class Song {
    String title;
    String artist;
    long year;
    public Song(){}
    public Song(String Title,String Artist,long Year) {
        this.title=Title;
        this.artist=Artist;
        this.year=Year;
    }
    public String getTitle() {
        return this.title;
    }
    public String getArtist() {
        return this.artist;
    }
    public long getYear() {
        return this.year;
    }
}
