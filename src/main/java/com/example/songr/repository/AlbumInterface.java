package com.example.songr.repository;

import com.example.songr.model.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumInterface extends JpaRepository<AlbumEntity, Long> {

}
