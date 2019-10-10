package DAO.DAOImpl;

import DAO.UserDAO;
import entity.User;
import utils.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    Connection connection = DBconnection.getConnection();

    @Override
    public User create(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users (email, password)values(?, ?)");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            String emailFromDB = resultSet.getString("email");
            String passwordFromDB = resultSet.getString("password");
            user = new User(userID, emailFromDB, passwordFromDB);
        }
        return user;
    }

    @Override
    public int update(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update users set (`email=?`, `password=?`) where `userID`=?");
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getUserId());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result;
    }

    @Override
    public int delete(int ID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete * from users where userID=?");
        preparedStatement.setInt(1, ID);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result;
    }

    @Override
    public User read(int ID) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userID =?");
        preparedStatement.setInt(1, ID);
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setUserId(ID);

        }
        preparedStatement.close();
        resultSet.close();
        return user;
    }

    @Override
    public int checkIfUserExistByEmail(String email) throws SQLException {
        int value = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where `email` = ?");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            value++;
        }
        return value;
    }

    @Override
    public User checkIfUserExistByEmailAndPassword(String email, String password) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where `email` = ? and `password` = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            int userID = resultSet.getInt(1);
            String emailDB = resultSet.getString(2);
            String passwordDB = resultSet.getString(3);
            user = new User(userID, email, password);
        }
        return user;
    }
}