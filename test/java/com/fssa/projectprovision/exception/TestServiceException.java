package com.fssa.projectprovision.exception;

import com.fssa.projectprovision.exception.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestServiceException {

    @Test
    public void testServiceException() {
        try {
            throw new ServiceException("Service exception with message");
        } catch (ServiceException e) {
            assertEquals("Service exception with message", e.getMessage());
        }
    }

    @Test
    public void testServiceExceptionWithThrowable() {
        Throwable cause = new RuntimeException("Root cause");
        try {
            throw new ServiceException(cause);
        } catch (ServiceException e) {
            assertEquals(cause, e.getCause());
        }
    }

    @Test
    public void testServiceExceptionWithMessageAndThrowable() {
        String message = "Service exception message";
        Throwable cause = new RuntimeException("Root cause");
        try {
            throw new ServiceException(message, cause);
        } catch (ServiceException e) {
            assertEquals(message, e.getMessage());
            assertEquals(cause, e.getCause());
        }
    }
}
