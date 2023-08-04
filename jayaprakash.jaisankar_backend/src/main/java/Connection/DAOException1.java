package Connection;

import java.sql.SQLException;


public class DAOException1 extends Exception {
    public DAOException1(String message, SQLException e) {
        super(message);
    }

    public DAOException1(String message, Throwable cause) {
        super(message, cause);
    }

	public DAOException1(String message, Exception e) {
		// TODO Auto-generated constructor stub
	}

	public void DAOException(String message, SQLException e) {
		// TODO Auto-generated constructor stub
	}

	
}
