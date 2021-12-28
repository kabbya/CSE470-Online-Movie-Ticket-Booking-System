package com.projectMovieTicket.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectMovieTicket.entities.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	List<Purchase> findByUserUserId(int userId);
	
	List<Purchase> findByMovieticketMovieId(int movieId);
	
	public Page<Purchase> findAll(Pageable pageable);
	
	@Query("FROM Purchase as p ORDER BY p.movieticket.date")
	public Page<Purchase> findAllOrderByMovieticketDateAsc(Pageable pageable);
	
	@Query("FROM Purchase as c where c.user.userId =: userUserId")
	List<Purchase> findPurchaseByUser( @Param("userUserId") int userUserId);

	@Query("FROM Purchase as p WHERE p.user.userId =:n")
	public List<Purchase> getPurchaseByUser(@Param("n") int n);
		
	@Query("FROM Purchase as p WHERE p.user.userId =:n and p.movieticket.date >=:m ORDER BY p.movieticket.date")
	public Page<Purchase> getPurchaseByUserAndMovieDate(@Param("n") int n, @Param("m") Date m, Pageable pageable);
	
	
	// Return Purchase List to the User based on current user sorted by movie date and purchase status
	 
	
	@Query("FROM Purchase as p WHERE p.user.userId =:n ORDER BY p.paymentStatus,p.movieticket.date")
	public Page<Purchase> getPurchaseByUser(@Param("n") int n, Pageable pageable);
	
	
	// Return Purchase List to the User based on current user, movie date, payment status and sorted by movie date
	 
	
	@Query("FROM Purchase as p WHERE p.user.userId =:n and p.movieticket.date >=:m and p.paymentStatus=:status ORDER BY p.movieticket.date")
	public Page<Purchase> getPurchaseByUserAndMovieDateAndPaymentStatus(@Param("n") int n, @Param("m") Date m, @Param("status") int status, Pageable pageable);

	
	// Return Purchase List to the Admin based on movie date and payment status
	 
	
	@Query("FROM Purchase as p WHERE p.paymentStatus =:status and p.movieticket.date >=:m")
	public Page<Purchase> getPurchaseByPaymentStatusAndMovieDate(@Param("status") int status,  @Param("m") Date m,Pageable pageable);

	
	// Delete purchase id
	
	@Modifying
	@Query("DELETE FROM Purchase as p WHERE p.purchaseId =:id")
	void deleteById(@Param("id") int id);
	

}
