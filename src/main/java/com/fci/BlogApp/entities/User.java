package com.fci.BlogApp.entities;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.TrueFalseConverter;import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;

//	@NotNull(message = "firstname is required")
//	@Size(min = 4, message = "name should be atleast 4 character")
//    @Column(name = "first_name", nullable = false)
	private String name;

//	@Email
//	@NotNull(message = "Email  id is required and can't be null")
//	@Column(name = "email_id")
	private String email;
	
//	@NotEmpty
//	@Size(min = 3,max = 15,message = "password must be grater than 3 and less than 15 character")
////	@pattern
	private String password;
	
//	@NotNull
//	@NotEmpty(message = "about is required and About can't be null value")
	private String about;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post>posts=new ArrayList<>();
}
