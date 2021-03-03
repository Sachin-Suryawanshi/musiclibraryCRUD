package com.thinkitive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MusicLibrary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer songId;
	private String songName;
	private String artistName;
	private Integer yearOfRealease;
	public MusicLibrary() {
		// TODO Auto-generated constructor stub
	}
	public MusicLibrary(Integer songId, String songName, String artistName, Integer yearOfRealease) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.artistName = artistName;
		this.yearOfRealease = yearOfRealease;
	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public Integer getYearOfRealease() {
		return yearOfRealease;
	}
	public void setYearOfRealease(Integer yearOfRealease) {
		this.yearOfRealease = yearOfRealease;
	}
	@Override
	public String toString() {
		return "MusicLibrary [songId=" + songId + ", songName=" + songName + ", artistName=" + artistName
				+ ", yearOfRealease=" + yearOfRealease + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((songId == null) ? 0 : songId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicLibrary other = (MusicLibrary) obj;
		if (songId == null) {
			if (other.songId != null)
				return false;
		} else if (!songId.equals(other.songId))
			return false;
		return true;
	}
	

}
