package com.example.songr;

import com.example.songr.albums.Album;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SongrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongrApplication.class, args);
		Album album = new Album();
		album.setTitle("SongTitle");
		album.setArtist("SongArtist");
		album.setSongCount(6);
		album.setLength(3000);

		System.out.println(album.toString());
	}

}
