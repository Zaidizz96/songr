package com.example.songr.controller;


import com.example.songr.model.AlbumEntity;
import com.example.songr.repository.AlbumInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumInterface albumInterface;

    @GetMapping("/")
    public String homePage(Model model) {
        List<AlbumEntity> albumEntityList = albumInterface.findAll();
        model.addAttribute("albumsList" , albumEntityList);
        return "splash";
    }

    @GetMapping("/addnew")
    public String addNewAlbum(Model model) {
        AlbumEntity album = new AlbumEntity();
        model.addAttribute("album", album);
        return "new-album";
    }

    @PostMapping("/save")
    public String saveAlbum(@ModelAttribute("album") AlbumEntity album){
        albumInterface.save(album);
        return "redirect:/";
    }
    @GetMapping("/deleteAlbum/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        albumInterface.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "index.html";
    }

    @GetMapping("/capitalize/{text}")
    public String convertToUpperCase(Model model, @PathVariable String text) {
        model.addAttribute("word", text.toUpperCase());
        return "capitalize.html";
    }
}



