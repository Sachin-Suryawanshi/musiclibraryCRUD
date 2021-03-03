package com.thinkitive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkitive.model.MusicLibrary;
@Repository
public interface MusicLibraryRepository extends JpaRepository<MusicLibrary, Integer>{
	public List<MusicLibrary> findBysongName(String name);

}
