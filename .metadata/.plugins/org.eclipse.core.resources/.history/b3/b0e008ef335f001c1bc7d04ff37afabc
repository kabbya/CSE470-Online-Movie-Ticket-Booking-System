package com.projectMovieTicket.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.projectMovieTicket.dao.MovieticketRepository;
import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.Movieticket;
import com.projectMovieTicket.entities.User;
import com.projectMovieTicket.helper.Message;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieticketRepository movieticketRepository;
	 
	// adding common data
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);		
		model.addAttribute("user", user);
	}
	
	
	// showing dashboard
	
	@RequestMapping("/dashboard")
	public String userDashboard(Model model, Principal principal) {
		model.addAttribute("title", "Admin Dashboard");
		return "adminuser/admin_dashboard";
	}
	
	
	// movie upload form
	
	@GetMapping("/upload-movie")
	public String uploadMovie(Model model) {
		model.addAttribute("title","Upload Movie");
		model.addAttribute("movieticket", new Movieticket () );
		return "adminuser/upload_movie_form";
	}
	
	
	// insert movie to database
	
	@PostMapping("/process-uploaded-movie")
	public 	String processMovie(
			@ModelAttribute Movieticket movieticket, 
			@RequestParam("movieImageUrl") MultipartFile file,
			HttpSession session) {
		
		try {
			
			if(file.isEmpty()) {
				movieticket.setMovieImage("movieDefault.jpg");
			}
			else {
				
				movieticket.setMovieImage(file.getOriginalFilename());
				File saveFile =  new ClassPathResource("static/img").getFile();
				Path path =   Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
				Files.copy(file.getInputStream(), path , StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Image uploaded.");
			}
			
			session.setAttribute("message", new Message("New Movie has been successfully uploaded", "success"));
			
			movieticket.setTotalSeat(movieticket.getSeatRemaining());
			movieticketRepository.save(movieticket);
		}
		catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong, try again ! ", "danger"));
		}
		
		return "adminuser/upload_movie_form";
		
	}
	
}
