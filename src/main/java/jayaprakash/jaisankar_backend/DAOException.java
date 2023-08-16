package jayaprakash.jaisankar_backend;

import java.sql.SQLException;

public class DAOException extends Exception {

	public DAOException(String string, SQLException e) {
		
	}

	public DAOException(String string, Exception e) {
		
	}

}
