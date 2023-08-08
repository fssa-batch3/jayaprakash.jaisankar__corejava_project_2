package stampmodule.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import surveyor.dao.SurveyorDAO;
import surveyor.dao.exception.SurveyorDAOException;
import surveyor.model.Surveyor;

class SurveyorDAOTest {

    private static SurveyorDAO surveyorDAO;

    @BeforeAll
    static void setUp() {
        surveyorDAO = new SurveyorDAO();
    }

    @BeforeEach
    void beforeEach() {
        // Set up any necessary mock objects or data
    }

    @Test
    void testRegisterSurveyor() throws SurveyorDAOException {
        Surveyor surveyor = new Surveyor("Jp", "chennai", "jaya@gmail.com");
        assertTrue(surveyorDAO.register(surveyor));
    }
    
    @Test
    void testGetSurveyorByName() throws SurveyorDAOException {
        String name = "Jp";
        Surveyor surveyor = surveyorDAO.getSurveyorByName(name);
        assertNotNull(surveyor);
        assertEquals(name, surveyor.getName());
    }

    @Test
    void testGetSurveyorByTaluk() throws SurveyorDAOException {
        String taluk = "chennai";
        Surveyor surveyor = surveyorDAO.getSurveyorByTaluk(taluk);
        assertNotNull(surveyor);
        assertEquals(taluk, surveyor.getTaluk());
    }

    @Test
    void testGetSurveyorByEmail() throws SurveyorDAOException {
        String email = "jaya@gmail.com";
        Surveyor surveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNotNull(surveyor);
        assertEquals("Jp", surveyor.getName());
        assertEquals("chennai", surveyor.getTaluk());
        assertEquals(email, surveyor.getEmail());
    }

    @Test
    void testUpdateSurveyorByName() throws SurveyorDAOException {
        String updatedName = "Smithan";
        String name = "Jp";
        assertTrue(surveyorDAO.updateSurveyorByName(updatedName, name));

        // Verify that the surveyor was updated correctly
        Surveyor updatedSurveyor = surveyorDAO.getSurveyorByName(updatedName);
        assertNotNull(updatedSurveyor);
        assertEquals(updatedName, updatedSurveyor.getName());
        assertEquals("chennai", updatedSurveyor.getTaluk());
        assertEquals("jaya@gmail.com", updatedSurveyor.getEmail());
    }

    @Test
    void testUpdateSurveyorByTaluk() throws SurveyorDAOException {
        String updatedTaluk = "Kandigai";
        String taluk = "chennai";
        assertTrue(surveyorDAO.updateSurveyorByTaluk(updatedTaluk, taluk));

        // Verify that the surveyor was updated correctly
        Surveyor updatedSurveyor = surveyorDAO.getSurveyorByTaluk(updatedTaluk);
        assertNotNull(updatedSurveyor);
        assertEquals("Smithan", updatedSurveyor.getName());
        assertEquals(updatedTaluk, updatedSurveyor.getTaluk());
        assertEquals("jaya@gmail.com", updatedSurveyor.getEmail());
    }

    @Test
    void testUpdateSurveyorByEmail() throws SurveyorDAOException {
        String updatedName = "Smithan";
        String updatedTaluk = "Kandigai";
        String email = "jaya@gmail.com";
        assertTrue(surveyorDAO.updateSurveyorByEmail(updatedName, updatedTaluk, email));

        // Verify that the surveyor was updated correctly
        Surveyor updatedSurveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNotNull(updatedSurveyor);
        assertEquals(updatedName, updatedSurveyor.getName());
        assertEquals(updatedTaluk, updatedSurveyor.getTaluk());
        assertEquals(email, updatedSurveyor.getEmail());
    }

    @Test
    void testDeleteSurveyorByName() throws SurveyorDAOException {
        String name = "Smithan";
        assertTrue(surveyorDAO.deleteSurveyorByEmail(name));

        // Verify that the surveyor was deleted
        Surveyor deletedSurveyor = surveyorDAO.getSurveyorByName(name);
        assertNull(deletedSurveyor);
    }

    @Test
    void testDeleteSurveyorByTaluk() throws SurveyorDAOException {
        String taluk = "Kandigai";
        assertTrue(surveyorDAO.deleteSurveyorByTaluk(taluk));

        // Verify that the surveyor was deleted
        Surveyor deletedSurveyor = surveyorDAO.getSurveyorByTaluk(taluk);
        assertNull(deletedSurveyor);
    }

    @Test
    void testDeleteSurveyorByEmail() throws SurveyorDAOException {
        String email = "jaya@gmail.com";
        assertTrue(surveyorDAO.deleteSurveyorByEmail(email));

        // Verify that the surveyor was deleted
        Surveyor deletedSurveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNull(deletedSurveyor);
    }
}
