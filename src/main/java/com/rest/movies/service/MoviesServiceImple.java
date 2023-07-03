package com.rest.movies.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.rest.movies.dao.MoviesRepository;
import com.rest.movies.pojo.MoviePojo;

@Service
@Transactional
public class MoviesServiceImple implements MoviesService {
	
	@Autowired
	MoviesRepository movieRepo;

	@Override
	public ArrayList<String> getAllMovies() {
		
		ArrayList<String> movieNameList = new ArrayList<String>();  
		movieRepo.findAll().forEach(e -> {
			movieNameList.add(e.getMovieName());
		});
		System.out.println(movieNameList);
		return movieNameList;
	}

	@Override
	public ArrayList<String> getMoviesByReleaseDate(String releaseDate) {
		
		ArrayList<String> movieListByReleaseDate = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(releaseDate, formatter);
		movieRepo.findByReleaseDate(date).forEach(e -> {
			movieListByReleaseDate.add(e.getMovieName());
		});
		System.out.println(movieListByReleaseDate);
		return movieListByReleaseDate;
	}

	@Override
	public List<String> getMoviesByGenre(String genre) {
		ArrayList<String> movieListByGenre = new ArrayList<String>();
		movieRepo.findByGenre(genre).forEach(e -> {
			movieListByGenre.add(e.getMovieName());
		});
		System.out.println(movieListByGenre);
		return movieListByGenre;
	}

	@Override
	public JsonObject getMovieOverview(String movieName) {
		MoviePojo list = movieRepo.findByMovieName(movieName);
		JsonObject json = new JsonObject();
		json.addProperty("movieName", list.getMovieName());
		json.addProperty("overview", list.getOverview());
		return json;
	}
	
	@Override
	public JsonObject getMovieCrew(String movieName) {
		MoviePojo list = movieRepo.findByMovieName(movieName);
		JsonObject json = new JsonObject();
		json.addProperty("movieName", list.getMovieName());
		json.addProperty("crew", list.getCrew());
		return json;
	}

	@Override
	public JsonObject getMoviesByLanguage(String language) {
		ArrayList<MoviePojo> movieList = movieRepo.findByOriginalLanguage(language);
		System.out.println("MOVIes********** " + movieList);
		JsonObject json = new JsonObject();
		json.addProperty("language", language);
		json.addProperty("movieNames", movieList.toString());
		return json;
	}
	

}
