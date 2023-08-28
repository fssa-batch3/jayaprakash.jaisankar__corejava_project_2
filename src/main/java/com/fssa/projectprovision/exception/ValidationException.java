package com.fssa.projectprovision.exception;


/**
 * 
 *  An exception class for indicating validation errors. This exception is thrown when
 * data validation fails in the application.
 * 
 * Usage:
 * try {
 *     // Code that might throw a ValidationException
 * } catch (ValidationException e) {
 *     // Handle the validation exception appropriately
 * }
 * 
 * 
 * @author JayaprakashJaisankar
 *
 */
public class ValidationException extends Exception {

	/**
	 * Creates a new ValidationException with the specified detail message.
	 *
	 * @param message The detail message describing the validation error.
	 */
	public ValidationException(String message) {
		super(message);
	} 

	/**
	 * Creates a new ValidationException with the specified cause.
	 *
	 * @param ex The cause of the validation exception.
	 */
	public ValidationException(Throwable ex) {
		super(ex);
	}

	/**
	 * Creates a new ValidationException with the specified detail message and cause.
	 *
	 * @param message The detail message describing the validation error.
	 * @param ex      The cause of the validation exception.
	 */
	public ValidationException(String message, Throwable ex) {
		super(message, ex);
	}
}