package com.projectMovieTicket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectMovieTicket.entities.Movieticket;

public interface MovieticketRepository extends JpaRepository<Movieticket, Integer>{
	
	
}
