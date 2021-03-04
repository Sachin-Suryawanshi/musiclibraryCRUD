package com.thinkitive.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.MusicLibrary;
import com.thinkitive.repository.MusicLibraryRepository;
import com.thinkitive.service.MusicLibraryDaoImpl;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class MusicLibraryController {
	@Autowired
	MusicLibraryDaoImpl musiclibrarydaoimpl;
	@Autowired
	MusicLibraryRepository musicLibraryRepository;
	@RequestMapping(value = "/insertmusiclibrary",method = RequestMethod.POST)
	public String insertMusicLibrary(@RequestBody MusicLibrary musicLibrary)
	{
		this.musiclibrarydaoimpl.insertMusicLibrary(musicLibrary);
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
		mllist=this.musiclibrarydaoimpl.getallmusiclibrary();
		return mllist;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getmusiclibrarybyid/{songId}",method = RequestMethod.GET)
	public Optional<MusicLibrary> getMusicLibraryById(@PathVariable("songId") Integer songId )
	{
		return musicLibraryRepository.findById(songId);
	}
	
	@RequestMapping("/getmusiclibrarybyname/{songName}")
	public MusicLibrary getMusicLibraryByName(@PathVariable("songName") String name)
	{
		
	
		return musicLibraryRepository.findBysongName(name);
	}
	
	
	@RequestMapping(value = "/deletemusiclibrary/{songId}",method = RequestMethod.DELETE)
	public String deleteMusicLibrary(@PathVariable("songId") Integer songId)
	{
		this.musiclibrarydaoimpl.deleteMusicLibrary(songId);
		return "Deleted Successfully";
	}
	@RequestMapping(value = "/updatemusiclibrary",method = RequestMethod.PUT)
	public String updateMusicLibrary(@RequestBody MusicLibrary musicLibrary)
	{
		 this.musiclibrarydaoimpl.updateMusicLibrary(musicLibrary);
		 return "Updated Successfully";
		
		
	}
	
	@RequestMapping(value = "/getallml")
	Page<MusicLibrary> getallml(Pageable page)
	{
		return musiclibrarydaoimpl.getallml(page);
	}
	@RequestMapping(value = "/getallmlordered")
	Page<MusicLibrary> getallmlordered(@PageableDefault(sort = "songId",direction = Direction.ASC,size = 20)Pageable page)
	{
		return musiclibrarydaoimpl.getallml(page);
	}


}
