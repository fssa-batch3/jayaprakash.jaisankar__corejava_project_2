package stampmodule.dao.test;


import static org.junit.Assert.*;
import org.junit.*;
import java.util.List;

import stampmodule.dao.DaoException;
import stampmodule.dao.StampDAO;
import stampmodule.model.Stamp;

public class TestStampUpdate {

    private StampDAO stampDAO;

    @Before
    public void setUp() {
        stampDAO = new StampDAO();
    }

    @Test
    public void testUpdateStamp() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("50 stamp");
        stamp.setImg("50 stamp.jpg");
        stamp.setRupees(50);
        stamp.setDescription("50 stamp description");

        // Add the stamp first
        assertTrue(stampDAO.addStamp(stamp));

        // Update the stamp's details
        stamp.setImg("50 stamp.jpg");
        stamp.setRupees(50);
        stamp.setDescription("50 stamp description");

        assertTrue(stampDAO.updateStamp(stamp));

        // Retrieve the updated stamp and verify the details
        Stamp updatedStamp = stampDAO.getStampByName("50 stamp");
        assertEquals("50 stamp.jpg", updatedStamp.getImg());
        assertEquals(50, updatedStamp.getRupees(),10);
        assertEquals("50 stamp description", updatedStamp.getDescription());

        // Clean up by deleting the test stamp
        assertTrue(stampDAO.deleteStamp("50 stamp"));
    }

    @Test
    public void testDeleteStamp() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("50 stamp");
        stamp.setImg("50 stamp.jpg");
        stamp.setRupees(50);
        stamp.setDescription("50 stamp description");

        // Add the stamp first
        assertTrue(stampDAO.addStamp(stamp));

        // Delete the stamp
        assertTrue(stampDAO.deleteStamp("50 stamp"));

        // Verify that the stamp no longer exists
        assertFalse(stampDAO.isStampRegistered("50 stamp"));
    }
}
