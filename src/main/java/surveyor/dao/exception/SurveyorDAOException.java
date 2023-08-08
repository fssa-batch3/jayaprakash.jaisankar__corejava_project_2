package surveyor.dao.exception;



public class SurveyorDAOException extends Exception {
    public SurveyorDAOException(String message) {
        super(message);
    }

    public SurveyorDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
