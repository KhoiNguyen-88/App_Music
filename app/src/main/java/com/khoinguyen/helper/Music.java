package com.khoinguyen.helper;

/**
 * Created by ceani_000 on 02/10/2015.
 */
public class Music {
    private String name_song;
    private String singer;
    private String url;

    public String getName_song() {
        return name_song;
    }

    public void setName_song(String name_song) {
        this.name_song = name_song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Music(String name_song, String singer, String url) {
        this.name_song = name_song;
        this.singer = singer;
        this.url = url;
    }

    public Music() {
    }
}
