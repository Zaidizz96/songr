package com.example.songr.controller;


import com.example.songr.model.AlbumEntity;
import com.example.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<AlbumEntity> albumEntityList = albumRepository.findAll();
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
        albumRepository.save(album);
        return "redirect:/";
    }
    @GetMapping("/deleteAlbum/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        albumRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "index.html";
    }

    @GetMapping("/capitalize/{text}")
    public String convertToUpperCase(Model model, @PathVariable String text) {
        model.addAttribute("word", text.toUpperCase());
        return "capitalize";
    }

    @GetMapping("/viewDetails/{id}")
    public String viewAlbumDetails(Model model, @PathVariable Long id) {
        Optional<AlbumEntity> album = albumRepository.findById(id);

        model.addAttribute("album", album.get());
        return "album-details";
    }
}



