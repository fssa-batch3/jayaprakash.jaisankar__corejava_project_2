package stampmodule.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stampmodule.dao.StampDAO;
import stampmodule.model.Stamp;
import stampmodule.dao.DaoException;

public class StampDAOTest {

    private StampDAO stampDAO;

    @BeforeEach
    public void setUp() {
        stampDAO = new StampDAO();
    }

    @Test
    public void testAddStamp() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("500Stamp");
        stamp.setImg("500Stamp.png");
        stamp.setRupees(10.0);
        stamp.setDescription("500Stamp description");

        assertTrue(stampDAO.addStamp(stamp));

        // Clean up
        assertTrue(stampDAO.deleteStamp("500Stamp"));
    }

    @Test
    public void testGetStampByName() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("500Stamp");
        stamp.setImg("500Stamp.png");
        stamp.setRupees(500);
        stamp.setDescription("500Stamp description");

        stampDAO.addStamp(stamp);

        Stamp retrievedStamp = stampDAO.getStampByName("500Stamp");
        assertNotNull(retrievedStamp);
        assertEquals("500Stamp", retrievedStamp.getStampName());
        assertEquals("500Stamp.png", retrievedStamp.getImg());
        assertEquals(500, retrievedStamp.getRupees(), 0.001);
        assertEquals("500Stamp description", retrievedStamp.getDescription());

        // Clean up
        assertTrue(stampDAO.deleteStamp("500Stamp"));
    }

    @Test
    public void testUpdateStamp() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("500Stamp");
        stamp.setImg("500Stamp.png");
        stamp.setRupees(1000);
        stamp.setDescription("500Stamp description");

        stampDAO.addStamp(stamp);

        stamp.setImg("update500Stamp.png");
        stamp.setRupees(2000);
        stamp.setDescription("Update 500Stamp description"); 

        assertTrue(stampDAO.updateStamp(stamp));

        Stamp updatedStamp = stampDAO.getStampByName("500Stamp");
        assertNotNull(updatedStamp);
        assertEquals("update500Stamp.png", updatedStamp.getImg());
        assertEquals(2000, updatedStamp.getRupees(), 0.001);
        assertEquals("Update 500Stamp description", updatedStamp.getDescription());

        // Clean up
        assertTrue(stampDAO.deleteStamp("500Stamp"));
    }


    @Test
    public void testDeleteStamp() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("500Stamp");
        stamp.setImg("500Stamp.png");
        stamp.setRupees(500);
        stamp.setDescription("500Stamp description");

        stampDAO.addStamp(stamp);

        assertTrue(stampDAO.deleteStamp("500Stamp"));
    }

    @Test
    public void testIsStampRegistered() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("500Stamp");
        stamp.setImg("500Stamp.png");
        stamp.setRupees(10.0);
        stamp.setDescription("500Stamp description");

        stampDAO.addStamp(stamp);

        assertTrue(stampDAO.isStampRegistered("500Stamp"));

        // Clean up
        assertTrue(stampDAO.deleteStamp("500Stamp"));
    }

    @Test
    public void testGetAllStamps() throws DaoException {
        int initialSize = stampDAO.getAllStamps().size();

        Stamp stamp1 = new Stamp();
        stamp1.setStampName("1000Stamp");
        stamp1.setImg("1000Stamp.png");
        stamp1.setRupees(10.0);
        stamp1.setDescription("1000Stamp description 1");
        stampDAO.addStamp(stamp1);

        Stamp stamp2 = new Stamp();
        stamp2.setStampName("Stamp2");
        stamp2.setImg("stamp2.png");
        stamp2.setRupees(20.0);
        stamp2.setDescription("stamp description 2");
        stampDAO.addStamp(stamp2);

        assertEquals(initialSize + 2, stampDAO.getAllStamps().size());

        // Clean up
        assertTrue(stampDAO.deleteStamp("1000Stamp"));
        assertTrue(stampDAO.deleteStamp("Stamp2"));
    }
}
