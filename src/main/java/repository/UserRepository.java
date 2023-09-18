package repository;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;


    public UserRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(User user)throws SQLException{
        String sql="INSERT INTO users(name, username, email, password) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getUserName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getPassword());

        int result =preparedStatement.executeUpdate();
        return result;

    }
    public User login(String userName)throws SQLException{
        String sql ="SELECT * FROM users WHERE username=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            User user =new User(
                    resultSet.getInt("idUser"),
                    resultSet.getString("name"),
                    resultSet.getString("userName"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            return user;
        }
        return null;
    }


}
