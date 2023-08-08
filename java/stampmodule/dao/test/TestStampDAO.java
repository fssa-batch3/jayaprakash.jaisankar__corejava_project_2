package stampmodule.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import stampmodule.dao.StampDAO;
import stampmodule.dao.DaoException;
import stampmodule.model.Stamp;

public class TestStampDAO {

    private static StampDAO stampDAO;

    @BeforeAll
    public static void setUp() {
        stampDAO = new StampDAO();
    }

    @AfterAll
    public static void tearDown() {
        // Clean up resources or perform any necessary actions
    }

    @Test
    public void testAddStampSuccess() throws DaoException {
        Stamp stamp = new Stamp();
        stamp.setStampName("100stamp");
        stamp.setImg("100stamp.jpg");
        stamp.setRupees(10);
        
        
        stamp.setDescription("A 100stamp");

        assertTrue(stampDAO.addStamp(stamp));
    }


    @Test
    public void testAddStampFailure() throws DaoException {
        Stamp stamp = new Stamp();
       
        stamp.setStampName("50 stamp");

        stampDAO.addStamp(stamp);
    }
    @Test
    public void testGetStampByNameSuccess() throws DaoException {
        String stampName = "100stamp";
        Stamp stamp = stampDAO.getStampByName(stampName);

        assertNotNull(stamp);
        assertEquals(stampName, stamp.getStampName());
    }

    @Test
    public void testGetStampByNameFailure() {
        String stampName = "NonExistentStamp";

        assertThrows(DaoException.class, () -> {
            stampDAO.getStampByName(stampName);
        });
    }

  
}
