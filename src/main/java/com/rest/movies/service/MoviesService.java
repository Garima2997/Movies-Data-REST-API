package com.rest.movies.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;


public interface MoviesService {
	
	public ArrayList<String> getAllMovies();
	
	public ArrayList<String> getMoviesByReleaseDate(String releaseDate);

	public List<String> getMoviesByGenre(String genre);

	public JsonObject getMovieOverview(String movieName);

	public JsonObject getMovieCrew(String movieName);

	public JsonObject getMoviesByLanguage(String language);

}
