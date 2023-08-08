package surveyor.validation;

import surveyor.model.*;
import surveyor.validation.exception.*;


public class SurveyorValidator {

    public static void validateSurveyor(Surveyor surveyor) throws SurveyorValidationException {
        if (!validateName(surveyor.getName()) ||
            !validateTaluk(surveyor.getTaluk()) ||
            !validateEmail(surveyor.getEmail())) {
            throw new SurveyorValidationException("Invalid surveyor data");
        }
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateTaluk(String taluk) {
        return taluk != null && !taluk.trim().isEmpty();
    }

    public static boolean validateEmail(String email) {
        // Validate email using a simple regex pattern
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email != null && email.matches(regex);
    }
}
