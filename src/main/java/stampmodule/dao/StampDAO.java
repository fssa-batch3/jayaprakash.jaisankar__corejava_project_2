package stampmodule.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stampmodule.model.Stamp;

public class StampDAO {

    // Connect to the database
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
        return connection;
    }

    // Add new stamp to DB
    public boolean addStamp(Stamp stamp) throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String insertQuery = "INSERT INTO stamps (stamp_name, img, rupees, description) VALUES (?, ?, ?, ?);";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setString(1, stamp.getStampName());
            pst.setString(2, stamp.getImg());
            pst.setDouble(3, stamp.getRupees());
            pst.setString(4, stamp.getDescription());

            int rows = pst.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            throw new DaoException("Error while adding stamp", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoException("Error while preparing or executing insert statement", e);
                }
            }
        }
    }

    // Retrieve stamp by name from DB
    public Stamp getStampByName(String name) throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String selectQuery = "SELECT * FROM stamps WHERE stamp_name = ?";
            PreparedStatement pst = connection.prepareStatement(selectQuery);
            pst.setString(1, name);

            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                Stamp stamp = new Stamp();
                stamp.setStampName(resultSet.getString("stamp_name"));
                stamp.setImg(resultSet.getString("img"));
                stamp.setRupees(resultSet.getDouble("rupees"));
                stamp.setDescription(resultSet.getString("description"));
                return stamp;
            } else {
                throw new DaoException("Stamp not found");
            }
        } catch (SQLException e) {
            throw new DaoException("Error while fetching stamp", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoException("Error while preparing or executing select statement", e);
                }
            }
        }
    }

    // Update stamp in DB
    public boolean updateStamp(Stamp stamp) throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String updateQuery = "UPDATE stamps SET img=?, rupees=?, description=? WHERE stamp_name=?";
            PreparedStatement pst = connection.prepareStatement(updateQuery);
            pst.setString(1, stamp.getImg());
            pst.setDouble(2, stamp.getRupees());
            pst.setString(3, stamp.getDescription());
            pst.setString(4, stamp.getStampName());

            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new DaoException("Error while updating stamp", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                	 throw new DaoException("Error while updating stamp", e);
                }
            }
        }
    }

    // Delete stamp from DB
    public boolean deleteStamp(String name) throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String deleteQuery = "DELETE FROM stamps WHERE stamp_name=?";
            PreparedStatement pst = connection.prepareStatement(deleteQuery);
            pst.setString(1, name);

            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            throw new DaoException("Error while deleting stamp", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                	throw new DaoException("Error while deleting stamp", e);
                }
            }
        }
    }

    // Check if a stamp with the given name exists
    public boolean isStampRegistered(String name) throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String selectQuery = "SELECT COUNT(*) FROM stamps WHERE stamp_name=?";
            PreparedStatement pst = connection.prepareStatement(selectQuery);
            pst.setString(1, name);

            ResultSet resultSet = pst.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            throw new DaoException("Error while checking stamp registration", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                	throw new DaoException("Error while checking if a stamp with the given name exists", e);
                }
            }
        }
    }

    // Retrieve a list of all stamps from DB
    public List<Stamp> getAllStamps() throws DaoException {
        Connection connection = null;
        try {
            connection = getConnection();

            String selectQuery = "SELECT * FROM stamps";
            PreparedStatement pst = connection.prepareStatement(selectQuery);

            ResultSet resultSet = pst.executeQuery();
            List<Stamp> stampList = new ArrayList<>();
            while (resultSet.next()) {
                Stamp stamp = new Stamp();
                stamp.setStampName(resultSet.getString("stamp_name"));
                stamp.setImg(resultSet.getString("img"));
                stamp.setRupees(resultSet.getDouble("rupees"));
                stamp.setDescription(resultSet.getString("description"));
                stampList.add(stamp);
            }
            return stampList;
        } catch (SQLException e) {
            throw new DaoException("Error while retrieving stamps", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                	  throw new DaoException("Error while retrieving stamps", e);
                }
            }
        }
    }
}
