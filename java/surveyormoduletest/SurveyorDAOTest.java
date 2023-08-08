package surveyormoduletest;

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
    void testGetSurveyorByEmail() throws SurveyorDAOException {
        String email = "jaya@gmail.com"; // Use the email from testRegisterSurveyor
        Surveyor surveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNotNull(surveyor);
        assertEquals("Jp", surveyor.getName());
        assertEquals("chennai", surveyor.getTaluk());
        assertEquals(email, surveyor.getEmail());
    }

    @Test
    void testUpdateSurveyorByEmail() throws SurveyorDAOException {
        String updatedName = "Smithan";
        String updatedTaluk = "Kandigai";
        String email = "jaya@gmail.com"; // Use the email from testRegisterSurveyor
        assertTrue(surveyorDAO.updateSurveyorByEmail(updatedName, updatedTaluk, email));

        // Verify that the surveyor was updated correctly
        Surveyor updatedSurveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNotNull(updatedSurveyor);
        assertEquals(updatedName, updatedSurveyor.getName());
        assertEquals(updatedTaluk, updatedSurveyor.getTaluk());
        assertEquals(email, updatedSurveyor.getEmail());
    }

    @Test
    void testDeleteSurveyorByEmail() throws SurveyorDAOException {
        String email = "jaya@gmail.com"; // Use the email from testRegisterSurveyor
        assertTrue(surveyorDAO.deleteSurveyorByEmail(email));

        // Verify that the surveyor was deleted
        Surveyor deletedSurveyor = surveyorDAO.getSurveyorByEmail(email);
        assertNull(deletedSurveyor);
    }
}
