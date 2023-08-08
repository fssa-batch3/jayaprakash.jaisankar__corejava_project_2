package surveyor.service.exception;


public class SurveyorServiceException extends Exception {
    public SurveyorServiceException(String message) {
        super(message);
    }

    public SurveyorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
