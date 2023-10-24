package com.fssa.projectprovision.exception;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestDAOException {

   
 
    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Test Error Message";
        DAOException daoException = new DAOException(errorMessage);

        assertNotNull(daoException);
        assertEquals(errorMessage, daoException.getMessage());
        assertNull(daoException.getCause());
    }

    @Test
    public void testConstructorWithCause() {
        String errorMessage = "Test Error Message";
        Throwable cause = new RuntimeException("Test Cause");
        DAOException daoException = new DAOException(errorMessage, cause);

        assertNotNull(daoException);
        assertEquals(errorMessage, daoException.getMessage());
        assertEquals(cause, daoException.getCause());
    }

    @Test 
    public void testConstructorWithThrowable() {
        Throwable cause = new RuntimeException("Test Cause");
        DAOException daoException = new DAOException(cause);

        assertNotNull(daoException);
        assertEquals(cause.toString(), daoException.getMessage());
        assertEquals(cause, daoException.getCause());
    }

    @Test
    public void testConstructorWithNullMessageAndCause() {
        DAOException daoException = new DAOException(null, null);

        assertNotNull(daoException);
        assertNull(daoException.getMessage());
        assertNull(daoException.getCause());
    }
}
