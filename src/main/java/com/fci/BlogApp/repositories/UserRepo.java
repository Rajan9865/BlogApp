package com.fci.BlogApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.BlogApp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>
{

}
