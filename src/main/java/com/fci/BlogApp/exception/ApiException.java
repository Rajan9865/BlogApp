/**
 * 
 */
package com.fci.BlogApp.exception;

/**
 * @author deby7
 *6:40:45 am
 *2023
 *BlogApp
 *TODO
 */
public class ApiException extends RuntimeException {

	public ApiException(String message) {
		super(message);
	}
	public ApiException() {
		super();
	}
}