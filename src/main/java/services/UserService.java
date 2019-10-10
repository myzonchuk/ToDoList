package services;
import entity.User;
import DAO.DAOImpl.UserDAOImpl;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;

public class UserService {

    static UserDAOImpl userDAOImpl = new UserDAOImpl();

    public static User login(String email, String password) throws SQLException {

        String md5Pass = DigestUtils.md5Hex(password);

        return userDAOImpl.checkIfUserExistByEmailAndPassword(email, md5Pass);
    }

    public static void registration(User user) throws SQLException {

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userDAOImpl.create(user);
    }
}

