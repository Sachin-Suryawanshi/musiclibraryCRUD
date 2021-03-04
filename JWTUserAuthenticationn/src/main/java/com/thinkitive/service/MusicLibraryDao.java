package com.thinkitive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thinkitive.model.MusicLibrary;
import com.thinkitive.repository.MusicLibraryRepository;

public interface MusicLibraryDao {
	public void insertMusicLibrary(MusicLibrary musiclibrary);
	public void deleteMusicLibrary(int id);
	public void updateMusicLibrary(MusicLibrary musiclibrary);
	public List<MusicLibrary> getallmusiclibrary();
	public Optional<MusicLibrary> searchMusicLibrary(int id);
	public MusicLibrary searchByName(String name);
	public Page<MusicLibrary> getallml(Pageable page);

}
