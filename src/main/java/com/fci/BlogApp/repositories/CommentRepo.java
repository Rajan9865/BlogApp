/**
 * 
 */
package com.fci.BlogApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fci.BlogApp.entities.Comment;

/**
 * @author Rajan.kumar
 *6:32:09 am
 *2023
 *BlogApp
 *TODO
 */
public interface CommentRepo  extends JpaRepository<Comment, Integer>{

}
