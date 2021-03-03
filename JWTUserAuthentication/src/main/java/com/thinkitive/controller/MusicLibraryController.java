package com.thinkitive.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.MusicLibrary;
import com.thinkitive.repository.MusicLibraryRepository;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class MusicLibraryController {

	@Autowired
	MusicLibraryRepository musicLibraryRepository;
	@RequestMapping(value = "/insertmusiclibrary",method = RequestMethod.POST)
	public String insertMusicLibrary(@RequestBody MusicLibrary musicLibrary)
	{
		musicLibraryRepository.save(musicLibrary);
		return "Music Library inserted Successfully";
	}
	
	@RequestMapping(value = "/insertmultiplemusiclibrary",method = RequestMethod.POST)
	public String insertMultipleLibrary(@RequestBody List<MusicLibrary> musiclibrarylist)
	{
		musicLibraryRepository.saveAll(musiclibrarylist);
		return "All Musical library added Successfully";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getallmusiclibrary",method = RequestMethod.GET)
	public List<MusicLibrary> getAllLibrary()
	{
		List<MusicLibrary> mllist=new ArrayList<MusicLibrary>();
		mllist=musicLibraryRepository.findAll();
		return mllist;
	}
	
	@RequestMapping("/getmusiclibrarybyid/{songId}")
	public Optional<MusicLibrary> getMusicLibraryById(@PathVariable("songId") Integer id )
	{
		return musicLibraryRepository.findById(id);
	}
	
	@RequestMapping("/getmusiclibrarybyname/{songName}")
	public List<MusicLibrary> getMusicLibraryByName(@PathVariable("songName") String name)
	{
		List<MusicLibrary> mllist=new ArrayList<>();
		mllist=musicLibraryRepository.findBysongName(name);
		return mllist;
	}
	@RequestMapping(value = "/deletemusiclibrary/{songId}",method = RequestMethod.DELETE)
	public String deleteMusicLibrary(@PathVariable("songId") Integer songId)
	{
		Optional<MusicLibrary> musiclibrary=musicLibraryRepository.findById(songId);
		if(musiclibrary.isPresent())
		{
			musicLibraryRepository.delete(musiclibrary.get());
			return "Music Library is deleted with id "+songId;		}
		else
		{
			throw new RuntimeException("Music Library is not found for id "+songId);
		}
	}
	@RequestMapping(value = "/updatemusiclibrary",method = RequestMethod.PUT)
	public MusicLibrary updateMusicLibrary(@RequestBody MusicLibrary musicLibrary)
	{
		return musicLibraryRepository.save(musicLibrary);
		
	}
	
}
