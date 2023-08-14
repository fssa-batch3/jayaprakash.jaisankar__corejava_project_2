package com.fssa.projectprovision.exception;

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
