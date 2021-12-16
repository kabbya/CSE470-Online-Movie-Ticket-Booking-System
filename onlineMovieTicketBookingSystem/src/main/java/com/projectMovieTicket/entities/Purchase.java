package com.projectMovieTicket.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE")
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;
	private int quantity;
	private boolean paymentStatus;

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Movieticket movieticket;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movieticket getMovieticket() {
		return movieticket;
	}

	public void setMovieticket(Movieticket movieticket) {
		this.movieticket = movieticket;
	}
	
	
}
