package DAO;

import entity.User;

import java.sql.SQLException;

public interface UserDAO extends DAO<User> {

    public int checkIfUserExistByEmail(String email) throws SQLException;
    public User checkIfUserExistByEmailAndPassword(String email, String password) throws SQLException;

}
