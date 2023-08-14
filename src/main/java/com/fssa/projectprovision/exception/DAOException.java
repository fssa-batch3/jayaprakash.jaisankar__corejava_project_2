package com.fssa.projectprovision.exception;

public class DAOException extends Exception {

	/**
	 * Constructs a new DAOException with the specified detail message.
	 *
	 * @param msg The detail message.
	 */
	public DAOException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a new DAOException with the specified cause.
	 *
	 * @param ex The cause of the exception.
	 */ 
	public DAOException(Throwable ex) {
		super(ex);
	}

	/**
	 * Constructs a new DAOException with the specified detail message and cause.
	 *
	 * @param msg The detail message.
	 * @param ex  The cause of the exception.
	 */
	public DAOException(String msg, Throwable ex) {
		super(msg, ex);
	}
}