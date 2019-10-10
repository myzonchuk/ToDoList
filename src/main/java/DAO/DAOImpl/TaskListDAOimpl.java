package DAO.DAOImpl;

import DAO.TaskListDAO;
import entity.TaskList;
import utils.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskListDAOimpl implements TaskListDAO {

    Connection connection = DBconnection.getConnection();

    @Override
    public TaskList create(TaskList taskList) throws SQLException {
        TaskList taskList1 = null;
        PreparedStatement preparedStatement = connection.prepareStatement("insert into tasklist(status,nameOfTask,userID)values(?,?,?)");
        preparedStatement.setInt(1, taskList.getStatus());
        preparedStatement.setString(2, taskList.getNameOfTask());
        preparedStatement.setInt(3, taskList.getUserID());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return taskList1;
    }


    @Override
    public int update(TaskList taskList) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update tasklist set (`status=?`, `nameOfTask=?`,`userID=?`) where `taskListID`=?");

        preparedStatement.setInt(1, taskList.getStatus());
        preparedStatement.setString(2, taskList.getNameOfTask());
        preparedStatement.setInt(3, taskList.getUserID());
        preparedStatement.setInt(4, taskList.getTaskListID());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result;
    }


    @Override
    public int delete(int ID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete * from tasklist where taskListID=?");
        preparedStatement.setInt(1, ID);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result;
    }

    @Override
    public TaskList read(int ID) throws SQLException {
        TaskList taskList = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from tasklist where taskListID =?");
        preparedStatement.setInt(1, ID);
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            taskList.setStatus(resultSet.getInt(2));
            taskList.setNameOfTask(resultSet.getString(3));
            taskList.setUserID(resultSet.getInt(4));
            taskList.setTaskListID(ID);

        }
        preparedStatement.close();
        resultSet.close();
        return taskList;
    }
}
