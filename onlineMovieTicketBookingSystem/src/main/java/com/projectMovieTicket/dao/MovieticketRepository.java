package com.projectMovieTicket.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectMovieTicket.entities.Movieticket;

public interface MovieticketRepository extends JpaRepository<Movieticket, Integer>{
	
	public List<Movieticket> findByDate(Date date);
	
	//currentPage-page , movie per page - 5
	public Page<Movieticket> findByDateGreaterThanEqualOrderByDateAsc(Date date, Pageable pePageable);
	
	public Page<Movieticket> findByDateLessThanEqualOrderByDateAsc(Date date, Pageable pePageable);
	
	// Delete Movie
	
	@Modifying
	@Query("DELETE FROM Movieticket as m WHERE m.movieId =:id")
	void deleteById(@Param("id") int id);	
	
	// search by movie name
	
	public List<Movieticket> findByMovieNameContaining(String movieName);
	
	
}
