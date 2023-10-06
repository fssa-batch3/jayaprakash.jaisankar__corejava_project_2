package com.fssa.projectprovision.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestValidationException {

    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Test Error Message";
        ValidationException validationException = new ValidationException(errorMessage);

        assertNotNull(validationException);
        assertEquals(errorMessage, validationException.getMessage());
        assertNull(validationException.getCause());
    }

    @Test
    public void testConstructorWithCause() {
        String errorMessage = "Test Error Message";
        Throwable cause = new RuntimeException("Test Cause");
        ValidationException validationException = new ValidationException(errorMessage, cause);

        assertNotNull(validationException);
        assertEquals(errorMessage, validationException.getMessage());
        assertEquals(cause, validationException.getCause());
    }

    @Test
    public void testConstructorWithThrowable() {
        Throwable cause = new RuntimeException("Test Cause");
        ValidationException validationException = new ValidationException(cause);

        assertNotNull(validationException);
        assertEquals(cause.toString(), validationException.getMessage());
        assertEquals(cause, validationException.getCause());
    }

    @Test
    public void testConstructorWithNullMessageAndCause() {
        ValidationException validationException = new ValidationException(null, null);

        assertNotNull(validationException);
        assertNull(validationException.getMessage());
        assertNull(validationException.getCause());
    }
}

