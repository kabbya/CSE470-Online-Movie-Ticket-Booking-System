package com.projectMovieTicket.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIETICKET")
public class Movieticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String genre;
	private String day;
	private String startTime;
	
	private Date date;
	private Date duration;
	
	private int totalSeat;
	private int seatRemaining;
	private int ticketPrize;
	
	private String movieImage;
	
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER, mappedBy = "movieticket")
	private List<Purchase> soldList;

	public Movieticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getSeatRemaining() {
		return seatRemaining;
	}

	public void setSeatRemaining(int seatRemaining) {
		this.seatRemaining = seatRemaining;
	}

	public int getTicketPrize() {
		return ticketPrize;
	}

	public void setTicketPrize(int ticketPrize) {
		this.ticketPrize = ticketPrize;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public List<Purchase> getSoldList() {
		return soldList;
	}

	public void setSoldList(List<Purchase> soldList) {
		this.soldList = soldList;
	}

	@Override
	public String toString() {
		return "Movieticket [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", day=" + day
				+ ", startTime=" + startTime + ", date=" + date + ", duration=" + duration + ", totalSeat=" + totalSeat
				+ ", seatRemaining=" + seatRemaining + ", ticketPrize=" + ticketPrize + ", movieImage=" + movieImage
				+ "]";
	}
	
	

	
	
}
