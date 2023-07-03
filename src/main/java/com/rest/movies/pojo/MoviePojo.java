package com.rest.movies.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "movies")
public class MoviePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer movieId;
	@Column(name= "movie_name")
	private String movieName;
	@Column(name = "release_date")
	private LocalDate releaseDate;
	@Column(name = "genre")
	private String genre;
	@Column(name = "country")
	private String country;
	@Column(name ="original_language")
	private String originalLanguage;
	@Column(name = "overview")
	private String overview;
	@Column(name = "crew")
	private String crew;
	
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	@Override
	public String toString() {
		return "MoviePojo [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate
				+ ", genre=" + genre + ", country=" + country + ", originalLanguage=" + originalLanguage + ", overview="
				+ overview + ", crew=" + crew + "]";
	}
	
	
	
	
	
}
