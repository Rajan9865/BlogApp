package com.rajan.BlogApp.exception;
/**
 * @author Rajan.kumar
 *6:51:26 am
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

/**
	 * 
	 */
	private static final long serialVersionUID = -7808177202109072966L;
String resourceName;
String fieldName;
long fieldValue;
String name;
public ResourceNotFoundException(String resourceName, String fieldName, Integer userId) {
	super(String.format("%s not found with %s : %s", resourceName, fieldName, userId));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = userId;
}
}
