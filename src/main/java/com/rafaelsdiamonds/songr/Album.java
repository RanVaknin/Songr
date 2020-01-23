package com.rafaelsdiamonds.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imgUrl;

    @OneToMany(mappedBy = "album")
    private List<Song> songList;


    public Album(String title, String artist, int songCount, int length, String imgUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imgUrl = imgUrl;
    }

    //JPA constructor
    public Album() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<Song> getSongList() {
        return songList;
    }
}
