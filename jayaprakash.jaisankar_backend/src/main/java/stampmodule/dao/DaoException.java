package stampmodule.dao;

import java.sql.SQLException;

public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

	public DaoException(String string, SQLException e) {
		// TODO Auto-generated constructor stub
	}
}
