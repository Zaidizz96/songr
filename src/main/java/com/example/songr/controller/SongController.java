package com.example.songr.controller;

import com.example.songr.exciptions.AlbumNotFoundException;
import com.example.songr.model.AlbumEntity;
import com.example.songr.model.Song;
import com.example.songr.repository.AlbumRepository;
import com.example.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SongController {

    @Autowired
    private  AlbumRepository albumRepository;
    @Autowired
    private  SongRepository songRepository;

    @GetMapping("/song-collections")
    public String songCollections(Model model){
        List<Song> songList = songRepository.findAll();
        model.addAttribute("songList" , songList);
        return "collection-of-songs";
    }

    @GetMapping("/addNew-Song/{albumId}")
    public String addNewSong(Model model , @PathVariable(value = "albumId") Long albumId){

        Optional<AlbumEntity> albumEntity = Optional.ofNullable(
                albumRepository.findById(albumId).orElseThrow(
                        () -> new AlbumNotFoundException("Could not find Album for this Song in db!")));

        Song song = new Song();
        song.setAlbumEntity(albumEntity.get());
        model.addAttribute("song" , song);

        return "new-song";
    }
    @PostMapping("/saveSong")
    public String saveSong(@ModelAttribute("song") Song song){

        songRepository.save(song);
        return "redirect:/song-collections";
    }

    @GetMapping("/deleteSong/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        songRepository.deleteById(id);
        return "redirect:/song-collections";
    }


}
