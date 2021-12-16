package com.projectMovieTicket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectMovieTicket.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
