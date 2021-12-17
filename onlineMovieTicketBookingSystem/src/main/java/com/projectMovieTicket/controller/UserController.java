package com.projectMovieTicket.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/dashboard")
	public String userDashboard(Model model, Principal principal) {
		String userName = principal.getName();
		User user =  userRepository.getUserByUserName(userName);
		model.addAttribute("title", "User Dashboard");
		model.addAttribute(user);
		return "normaluser/user_dashboard";
	}
}
