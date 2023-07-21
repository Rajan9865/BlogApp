package com.fci.BlogApp.payloads;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
//@Setter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	private String message;
	private boolean success;

}
