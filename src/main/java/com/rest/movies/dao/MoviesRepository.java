package com.rest.movies.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.movies.pojo.MoviePojo;

@Repository
public interface MoviesRepository extends JpaRepository<MoviePojo, Integer> {
	
	ArrayList<MoviePojo> findByReleaseDate(LocalDate releaseDate);

	ArrayList<MoviePojo> findByGenre(String genre);
	
	MoviePojo findByMovieName(String movieName);
	
	ArrayList<MoviePojo> findByOriginalLanguage(String language);
	
}
