package stampmodule.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import stampmodule.dao.DaoException;
import stampmodule.dao.StampDAO;
import stampmodule.model.Stamp;

public class TestStampUpdate {

    private StampDAO stampDAO;

    @BeforeEach
    public void setUp() {
        stampDAO = new StampDAO();
    }

    @Test
    public void testUpdateStamp() {
        // Create a sample stamp to update
        Stamp originalStamp = new Stamp();
        originalStamp.setStampName("TestStamp");
        originalStamp.setImg("test.jpg");
        originalStamp.setRupees(10.0);
        originalStamp.setDescription("Test description");

        try {
            // Add the original stamp to the database
            stampDAO.addStamp(originalStamp);

            // Update the stamp details
            Stamp updatedStamp = new Stamp();
            updatedStamp.setStampName("TestStamp");
            updatedStamp.setImg("updated.jpg");
            updatedStamp.setRupees(15.0);
            updatedStamp.setDescription("Updated description");

            // Perform the update
            boolean updateResult = stampDAO.updateStamp(updatedStamp);

            // Check if the update was successful
            assertTrue(updateResult);

            // Retrieve the updated stamp from the database
            Stamp retrievedStamp = stampDAO.getStampByName("TestStamp");

            // Compare the updated stamp details
            assertEquals("TestStamp", retrievedStamp.getStampName());
            assertEquals("updated.jpg", retrievedStamp.getImg());
            assertEquals(15.0, retrievedStamp.getRupees());
            assertEquals("Updated description", retrievedStamp.getDescription());

        } catch (DaoException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
