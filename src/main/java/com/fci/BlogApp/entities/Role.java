/**
 * 
 */
package com.fci.BlogApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

}
