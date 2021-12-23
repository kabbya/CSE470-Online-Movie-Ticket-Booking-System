package com.projectMovieTicket.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectMovieTicket.dao.MovieticketRepository;
import com.projectMovieTicket.dao.PurchaseRepository;
import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.Movieticket;
import com.projectMovieTicket.entities.Purchase;
import com.projectMovieTicket.entities.User;
import com.projectMovieTicket.helper.Message;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MovieticketRepository movieticketRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	

	// adding common data

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
	}

	// user dashboard

	@RequestMapping("/dashboard")
	public String userDashboard(Model model, Principal principal) {
		model.addAttribute("title", "User Dashboard");
		return "normaluser/user_dashboard";
	}

	
	
	// show upcoming movies Normal User view

	
	@GetMapping("/show-upcoming-movie/{page}")
	public String showMovies(@PathVariable("page") Integer page, Model m) {

		LocalDate localDate = LocalDate.now();
		Date date = Date.valueOf(localDate);

		Pageable pageable = PageRequest.of(page, 5);
		Page<Movieticket> movietickets = this.movieticketRepository.findByDateGreaterThanEqualOrderByDateAsc(date,
				pageable);

		m.addAttribute("title", "Movie list User view");
		m.addAttribute("movietickets", movietickets);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", movietickets.getTotalPages());

		return "normaluser/show_upcoming_movie";
	}

	// buy movie tickets

	@RequestMapping("/buy-movie-ticket/{id}")
	public String buyMovieTicket(@PathVariable("id") Integer id, Model model) {

		Movieticket movieticket = this.movieticketRepository.getById(id);
		model.addAttribute("title", movieticket.getMovieName() + " Buy Movie Ticket");
		model.addAttribute("movieticket", movieticket);

		return "normaluser/buy_movie_ticket";
	}

	// process buy movie ticket : update database

	@PostMapping("/process-buy-ticket/{id}")
	public String processBuyTicket(@ModelAttribute Purchase purchase, @PathVariable("id") Integer id,
			Principal principal, Model model, HttpSession session) {

		Movieticket movieticket = this.movieticketRepository.getById(id);
		model.addAttribute("title", movieticket.getMovieName() + " Buy Movie Ticket");
		model.addAttribute("movieticket", movieticket);

		try {

			if (purchase.getQuantity() <= 0) {
				throw new Exception("No seat has been selected.");
			}

			if (movieticket.getSeatRemaining() - purchase.getQuantity() < 0) {
				throw new Exception("We don't have enough seats.");
			}

			movieticket.setSeatRemaining(movieticket.getSeatRemaining() - purchase.getQuantity());

			String userName = principal.getName();
			User user = this.userRepository.getUserByUserName(userName);

			purchase.setUser(user);
			purchase.setMovieticket(movieticket);

			user.getPurchaseList().add(purchase);
			movieticket.getSoldList().add(purchase);

			purchaseRepository.save(purchase);
			session.setAttribute("message", new Message("Ticket successfully purchased.", "success"));

			return "normaluser/buy_movie_ticket";

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong. " + e.getMessage(), "danger"));
			return "normaluser/buy_movie_ticket";
		}

	}

	
	
	// show upcoming movies in user's purchase list
	
	
	@GetMapping("/show-user-purchase/{page}")
	public String showUserPurchase(@PathVariable("page") Integer page, Model m, Principal principal) {
		
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		
		LocalDate localDate = LocalDate.now(); 
		Date date = Date.valueOf(localDate);
		int status = 1;

		Pageable pageable = PageRequest.of(page, 3);
		Page<Purchase> purchaseList = purchaseRepository.getPurchaseByUserAndMovieDateAndPaymentStatus(user.getUserId(), date, status, pageable );
		
		m.addAttribute("title", "My Movie Watchlist");
		m.addAttribute("purchaseList", purchaseList);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", purchaseList.getTotalPages());
		

		return "normaluser/show_user_purchase";

	}
	
	

	// show user transaction history
	
	
	@GetMapping("/show-user-transaction/{page}")
	public String showUserTransaction(@PathVariable("page") Integer page, Model m, Principal principal) {
		
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);	

		Pageable pageable = PageRequest.of(page, 5);
		Page<Purchase> purchaseList = purchaseRepository.getPurchaseByUser(user.getUserId(),pageable );
		
		m.addAttribute("title", "My Movie Watchlist");
		m.addAttribute("purchaseList", purchaseList);
		m.addAttribute("currentPage", page);
		m.addAttribute("totalPages", purchaseList.getTotalPages());
		

		return "normaluser/show_user_transaction";

	}
	
}
