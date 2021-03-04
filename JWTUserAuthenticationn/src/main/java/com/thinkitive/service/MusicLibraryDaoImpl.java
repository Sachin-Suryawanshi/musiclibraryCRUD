package com.thinkitive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thinkitive.model.MusicLibrary;
import com.thinkitive.repository.MusicLibraryRepository;
@Service
public class MusicLibraryDaoImpl implements MusicLibraryDao{

	@Autowired
	MusicLibraryRepository musiclibraryrepository;
	@Override
	public void insertMusicLibrary(MusicLibrary musiclibrary) {
	
		this.musiclibraryrepository.save(musiclibrary);
	}

	@Override
	public void deleteMusicLibrary(int id) {
		this.musiclibraryrepository.deleteById(id);
		
	}

	@Override
	public void updateMusicLibrary(MusicLibrary musiclibrary) {
		this.musiclibraryrepository.save(musiclibrary);
		
	}

	@Override
	public List<MusicLibrary> getallmusiclibrary() {
		return this.musiclibraryrepository.findAll();
	}

	@Override
	public Optional<MusicLibrary> searchMusicLibrary(int id) {
		
		return this.musiclibraryrepository.findById(id);
	}

	@Override
	public MusicLibrary searchByName(String name) {
		
		return this.musiclibraryrepository.findBysongName(name);
	}

	@Override
	public Page<MusicLibrary> getallml(Pageable page)
	{
		
		return musiclibraryrepository.findAll(page);
		
	}

	

	

}
