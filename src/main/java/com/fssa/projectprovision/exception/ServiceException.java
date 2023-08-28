package com.fssa.projectprovision.exception;

/**
 * 
 * 
 * An exception class for indicating errors related to service layer operations.
 * This exception is thrown when errors occur during business logic or service operations.
 * 
 * Usage:
 * try {
 *     // Code that might throw a ServiceException
 * } catch (ServiceException e) {
 *     // Handle the exception appropriately
 * }



 * @author JayaprakashJaisankar
 *
 */
public class ServiceException extends Exception {

    /**
     * Creates a new ServiceException with the specified detail message.
     *
     * @param msg The detail message.
     */
    public ServiceException(String msg) {
        super(msg);
    }

    /**
     * Creates a new ServiceException with the specified cause.
     * 
     * @param ex The cause of the exception.
     */
    public ServiceException(Throwable ex) {
        super(ex);
    }

    /**
     * Creates a new ServiceException with the specified detail message and cause.
     *
     * @param msg The detail message.
     * @param ex  The cause of the exception.
     */
    public ServiceException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
