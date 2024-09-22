/**
 * 
 */
package com.rajan.BlogApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Rajan.kumar
 *7:30:45 am
 *2023
 *BlogApp
 *TODO
 */
@Entity
@Data
public class Role {

	@Id	
	private int id;
	
	private String name;
	
}
