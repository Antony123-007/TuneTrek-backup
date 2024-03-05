package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	SongRepository songrepo;

	@Override
	public String addSong(Song song) {
		songrepo.save(song);
		return "Song Added Successfully"; 
	}

	@Override
	public boolean songExists(String name) {
		Song song = songrepo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songrepo.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song s) {
		songrepo.save(s);
		
	}

}
