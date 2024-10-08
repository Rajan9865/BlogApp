package com.rajan.BlogApp.payloads;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotNull(message = "firstname is required")
	@Size(min = 4, message = "name should be atleast 4 character")
	@Size(max = 15, message = "name should be not grater than 15 character")
    @Column(name = "first_name", nullable = false)
	private String name;
	
	@Email
	@NotNull(message = "Email  id is required and can't be null  ")
	@Column(name = "email_id")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 15,message = "Password must be grater than 3 and less than 15 character")
//	@pattern
	private String password;
	
	@NotNull
	@NotEmpty(message = "about is and About can't be null value ")
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
}
