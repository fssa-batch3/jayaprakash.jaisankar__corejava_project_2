package com.fssa.projectprovision.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestServiceException {

    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Test Error Message";
        ServiceException serviceException = new ServiceException(errorMessage);

        assertNotNull(serviceException);
        assertEquals(errorMessage, serviceException.getMessage());
        assertNull(serviceException.getCause());
    }

    @Test
    public void testConstructorWithCause() {
        String errorMessage = "Test Error Message";
        Throwable cause = new RuntimeException("Test Cause");
        ServiceException serviceException = new ServiceException(errorMessage, cause);

        assertNotNull(serviceException);
        assertEquals(errorMessage, serviceException.getMessage());
        assertEquals(cause, serviceException.getCause());
    }

    @Test
    public void testConstructorWithThrowable() {
        Throwable cause = new RuntimeException("Test Cause");
        ServiceException serviceException = new ServiceException(cause);

        assertNotNull(serviceException);
        assertEquals(cause.toString(), serviceException.getMessage());
        assertEquals(cause, serviceException.getCause());
    }

    @Test
    public void testConstructorWithNullMessageAndCause() {
        ServiceException serviceException = new ServiceException(null, null);

        assertNotNull(serviceException);
        assertNull(serviceException.getMessage());
        assertNull(serviceException.getCause());
    }
}
