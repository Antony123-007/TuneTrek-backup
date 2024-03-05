package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.PlayListService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PlayListController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlayListService playlistService;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playlist) {
		//updating the playlist table
		playlistService.addplaylist(playlist);
		
		//updating the song table
		List<Song> songList = playlist.getSongs();
		for (Song s : songList) {
			s.getPlaylist().add(playlist);
			songService.updateSong(s);
		}
		return "adminhome";
	}
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<PlayList> allPlaylist = playlistService.fetchAllPlaylists();
		
		model.addAttribute("allplaylist", allPlaylist);
		return "displayplaylist";
	}

}
