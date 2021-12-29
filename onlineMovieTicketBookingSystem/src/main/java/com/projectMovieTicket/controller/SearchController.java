package com.projectMovieTicket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.projectMovieTicket.dao.MovieticketRepository;
import com.projectMovieTicket.entities.Movieticket;


@RestController
public class SearchController {
	
	
	@Autowired
	private MovieticketRepository movieticketRepository;
	
	// search handler
	
	
	@GetMapping("/search/{query}")
	public ResponseEntity<?> searchByMovieName(@PathVariable("query") String query){
		
		List<Movieticket> movieticketList = movieticketRepository.findByMovieNameContaining(query);
		return ResponseEntity.ok(movieticketList);
		
	}
}
