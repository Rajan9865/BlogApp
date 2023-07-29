package com.fci.BlogApp.repositories;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.BlogApp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	Optional<User>findByEmail(String email);

}
