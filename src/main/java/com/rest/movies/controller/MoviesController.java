package com.rest.movies.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.rest.movies.service.MoviesService;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	MoviesService movieService;
	
	@GetMapping(value="/getAllMovies",  produces="application/json" )
	public ResponseEntity<?> getAllMovies(){
		List<String> moviesList = movieService.getAllMovies();
		Type listType = new TypeToken<List<String>>() {}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(moviesList , listType );
		return ResponseEntity.ok(json);
	}
	
	// get movies name by realease date
	@GetMapping("/getMoviesByReleaseDate/{releaseDate}")
	public ResponseEntity<?> getMoviesByRealeaseDate(@PathVariable String releaseDate){
		
		List<String> movieList = movieService.getMoviesByReleaseDate(releaseDate);
		Type listType = new TypeToken<List<String>>() {}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(movieList , listType );
		return ResponseEntity.ok(json);
	}
	
	// manual query
	@GetMapping(value = "/getMoviesByGenre/{genre}" , produces = "application/json")
	public ResponseEntity<?> getMoviesByGenre(@PathVariable String genre){
		
		List<String> movieList = movieService.getMoviesByGenre(genre);
//		Type listType = new TypeToken<List<String>>() {}.getType();
//		Gson gson = new GsonBuilder().create();
//		
//		String json = gson.toJson(movieList , listType );
		return ResponseEntity.ok(movieList);
	}
	
	@GetMapping(value = "/getMovieOverview/{movieName}", produces = "application/json")
	public ResponseEntity<?> getMovieOverview(@PathVariable String movieName){
		
		JsonObject movieList = movieService.getMovieOverview(movieName);
		return ResponseEntity.ok(movieList.toString());
	}
	
	@GetMapping(value = "/getMovieCrew/{movieName}", produces = "application/json")
	public ResponseEntity<?> getMovieCrew(@PathVariable String movieName){
		
		JsonObject movieList = movieService.getMovieCrew(movieName);
		return ResponseEntity.ok(movieList.toString());
	}
	
	
	@GetMapping(value = "/getMovieLanguage/{language}", produces = "application/json")
	public ResponseEntity<?> getMoviesByLanguage(@PathVariable String language){
		
		JsonObject movieList = movieService.getMoviesByLanguage(language);
		return ResponseEntity.ok(movieList.toString());
	}
	
	
	
	

	
}
