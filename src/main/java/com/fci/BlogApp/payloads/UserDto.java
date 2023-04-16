package com.fci.BlogApp.payloads;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotEmpty(message = "about is and About can't be null value bch")
	private String about;
}
