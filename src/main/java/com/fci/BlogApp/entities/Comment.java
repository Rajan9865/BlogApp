/**
 * 
 */
package com.fci.BlogApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rajan.kumar
 *6:13:54 am
 *2023
 *BlogApp
 *TODO
 */

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String content;
	
	@ManyToOne
	private Post post;
}
