package com.projectMovieTicket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.projectMovieTicket.dao.UserRepository;
import com.projectMovieTicket.entities.User;

public class UserDetailsServiceImplementation implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user  =  userRepository.getUserByUserName(username);

		if(user==null) {
			throw new UsernameNotFoundException("Could Not Found User !!");
		}

		CustomUserDetails customerUserDetails = new CustomUserDetails(user);
		return customerUserDetails;
	}

}
