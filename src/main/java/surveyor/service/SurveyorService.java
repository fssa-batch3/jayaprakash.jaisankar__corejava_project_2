package surveyor.service;

import surveyor.dao.*;
import surveyor.model.*;
import surveyor.service.exception.*;
import surveyor.validation.SurveyorValidator;
import surveyor.validation.exception.*;


public class SurveyorService {
    private SurveyorDAO surveyorDAO;

    public SurveyorService() {
        surveyorDAO = new SurveyorDAO();
    }
    public boolean registerSurveyor(String name, String taluk, String email) throws SurveyorServiceException {
        try {
            Surveyor surveyor = new Surveyor(name, taluk, email);
            SurveyorValidator.validateSurveyor(surveyor);
            return surveyorDAO.register(surveyor);
        } catch (SurveyorValidationException e) {
            throw new SurveyorServiceException("Invalid surveyor data", e);
        } catch (Exception e) {
            throw new SurveyorServiceException("Error registering surveyor", e);
        }
    }

    public boolean updateSurveyorInfo(String name, String taluk, String email) throws SurveyorServiceException {
        try {
            return surveyorDAO.updateSurveyorByEmail(name, taluk, email);
        } catch (Exception e) {
            throw new SurveyorServiceException("Error updating surveyor information", e);
        }
    }

}
