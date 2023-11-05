package com.fssa.projectprovision.exception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
/**
 * 
 */
public class TestDAOException {
	@Test
	public	void testDAOException() {
		try {  
			throw new DAOException("DAO exception with message");
		} catch (DAOException e) {
			assertEquals("DAO exception with message", e.getMessage());
		}
	} 

	@Test
	public void testDAOExceptionWithThrowable() {
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new DAOException(cause);
		} catch (DAOException e) {
			assertEquals(cause, e.getCause());
		}
	}

	@Test
	public void testDAOExceptionWithMessageAndThrowable() {
		String message = "DAO exception message";
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new DAOException(message, cause);
		} catch (DAOException e) {
			assertEquals(message, e.getMessage());
			assertEquals(cause, e.getCause());
		}
	}

}