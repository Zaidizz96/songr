package com.example.songr.controller;

import com.example.songr.albums.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongController {

    @GetMapping("/")
    public String homePage() {
        return "splash.html";
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

    @GetMapping("/albums")
    public String albums(Model model) {
        Album[] albums = new Album[3];
        Album album1 = new Album("Three Days Grace", "Three Days Grace", 12, 2400.5, "https://e7.pngegg.com/pngimages/1020/1015/png-clipart-three-days-grace-never-too-late-musician-art-three-days-grace-white-text-thumbnail.png");
        Album album2 = new Album("One-X", "Three Days Grace", 12, 2250.4, "https://e7.pngegg.com/pngimages/87/401/png-clipart-linkin-park-new-divide-logo-music-linkin-park-logo-text-label-thumbnail.png");
        Album album3 = new Album("Life Starts Now", "Three Days Grace", 12, 2400.10, "https://e7.pngegg.com/pngimages/625/460/png-clipart-three-days-grace-transit-of-venus-album-human-life-starts-now-rockfort-rock-album-label-thumbnail.png");

        albums[0] = album1;
        albums[1] = album2;
        albums[2] = album3;

        model.addAttribute("albumsArray", albums);
        return "albums.html";
    }

}
