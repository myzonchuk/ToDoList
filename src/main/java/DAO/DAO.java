package DAO;

import java.sql.SQLException;

public interface DAO<Entity> {
    Entity create(Entity model) throws SQLException;

    int update(Entity model) throws SQLException;

    int delete(int ID) throws SQLException;

    Entity read(int ID) throws SQLException;
}
