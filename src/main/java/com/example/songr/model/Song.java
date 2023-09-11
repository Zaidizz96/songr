package com.example.songr.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int length;
    private int trackNumber;
    @ManyToOne
    @JoinColumn(name="album_entity_id", nullable=false)
    private AlbumEntity albumEntity;

    public Song() {
    }

    public Song(String title, int length, int trackNumber, AlbumEntity albumEntity) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.albumEntity=albumEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public AlbumEntity getAlbumEntity() {
        return albumEntity;
    }

    public void setAlbumEntity(AlbumEntity albumEntity) {
        this.albumEntity = albumEntity;
    }
}
