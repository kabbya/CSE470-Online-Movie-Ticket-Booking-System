package com.projectMovieTicket.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectMovieTicket.dao.MovieticketRepository;
import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.Movieticket;
import com.projectMovieTicket.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieticketRepository movieticketRepository;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);		
		model.addAttribute("user", user);
	}
	
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
		    
	    Pageable pageable =  PageRequest.of(page, 5);
	    Page<Movieticket> movietickets = this.movieticketRepository.findByDateGreaterThanEqualOrderByDateAsc(date,pageable);
			
		m.addAttribute("title", "Movie list User view");
		m.addAttribute("movietickets", movietickets);
		m.addAttribute("currentPage",page);
		m.addAttribute("totalPages",movietickets.getTotalPages());
		
		return "normaluser/show_upcoming_movie";
	}	
	
	
}
