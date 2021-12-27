package com.projectMovieTicket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.User;
import com.projectMovieTicket.helper.Message;

@Controller
public class HomeController {
	
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired 
	private UserRepository userRepository;
	
	// Home Page 
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Online Movie Ticket Booking System");
		return "home";
	}
	
	// Registration Page
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Registration - Online Movie Ticket Booking System");
		model.addAttribute("user", new User() );
		return "signup";
	}
	
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, 
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, 
			Model model, HttpSession session ) {
		
		try {
			
			if(!agreement) {
				throw new Exception("You have not agreed the terms and condition");
			}
			
			user.setRole("ROLE_USER");
			user.setEnable(true);
			user.setImgUrl("User Profile Default Photo.png");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			this.userRepository.save(user);
			model.addAttribute("user", new User() );
			session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
			return "signup";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong." + e.getMessage(), "alert-danger"));
			return "signup";
		}
		
	}
	
	
	@GetMapping("/login")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login");
		return "login";
		
	}
}
