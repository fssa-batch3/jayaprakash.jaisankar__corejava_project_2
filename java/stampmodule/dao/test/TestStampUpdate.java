package stampmodule.dao.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stampmodule.dao.DaoException;
import stampmodule.dao.StampDAO;
import stampmodule.model.Stamp;

public class TestStampUpdate {

    private StampDAO stampDAO;

    @Before
    public void setUp() throws Exception {
        // Set up the StampDAO instance before each test
        stampDAO = new StampDAO();
    }

    @After
    public void tearDown() throws Exception {
        // Clean up any resources after each test (if needed)
    }

    @Test
    public void testUpdateStamp() throws DaoException {
        // Create a new Stamp object with updated information
        Stamp updatedStamp = new Stamp();
        updatedStamp.setStampName("Test Stamp");
        updatedStamp.setImg("new_image.jpg");
        updatedStamp.setRupees(10.5);
        updatedStamp.setDescription("Updated stamp description");

        // Call the updateStamp method
        boolean result = stampDAO.updateStamp(updatedStamp);

        // Check if the update was successful
        assertTrue(result);

        // Retrieve the updated stamp from the database
        Stamp retrievedStamp = stampDAO.getStampByName("Test Stamp");

        // Check if the retrieved stamp matches the updated information
        assertEquals("new_image.jpg", retrievedStamp.getImg());
        assertEquals(10.5, retrievedStamp.getRupees(), 0.001);
        assertEquals("Updated stamp description", retrievedStamp.getDescription());
    }

    @Test
    public void testDeleteStamp() throws DaoException {
        // Create a new Stamp object to be deleted
        Stamp stampToDelete = new Stamp();
        stampToDelete.setStampName("Stamp to Delete");
        stampToDelete.setImg("delete_image.jpg");
        stampToDelete.setRupees(5.0);
        stampToDelete.setDescription("Stamp to be deleted");

        // Add the stamp to the database for testing
        boolean addResult = stampDAO.addStamp(stampToDelete);
        assertTrue(addResult);

        // Call the deleteStamp method
        boolean deleteResult = stampDAO.deleteStamp("Stamp to Delete");

        // Check if the delete was successful
        assertTrue(deleteResult);

        // Attempt to retrieve the deleted stamp
        try {
            stampDAO.getStampByName("Stamp to Delete");
            fail("Expected DaoException but got none.");
        } catch (DaoException e) {
            // Expected behavior
        }
    }
}

