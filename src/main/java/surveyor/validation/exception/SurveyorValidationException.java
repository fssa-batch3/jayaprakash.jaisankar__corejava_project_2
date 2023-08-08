package surveyor.validation.exception;


public class SurveyorValidationException extends Exception {
    public SurveyorValidationException(String message) {
        super(message);
    }

    public SurveyorValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
