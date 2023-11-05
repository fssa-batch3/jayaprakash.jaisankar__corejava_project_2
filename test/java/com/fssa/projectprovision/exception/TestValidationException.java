package com.fssa.projectprovision.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidationException {
	@Test
	public void testValidationException() {
		try {
			throw new ValidationException("Validation exception with message");
		} catch (ValidationException e) {
			assertEquals("Validation exception with message", e.getMessage());
		}
	}
 
	@Test
	public void testValidationExceptionWithThrowable() {
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new ValidationException(cause);
		} catch (ValidationException e) {
			assertEquals(cause, e.getCause());
		}
	}
 
	@Test
	public void testValidationExceptionWithMessageAndThrowable() {
		String message = "Validation exception message";
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new ValidationException(message, cause);
		} catch (ValidationException e) {
			assertEquals(message, e.getMessage());
			assertEquals(cause, e.getCause());
		}
	}
}