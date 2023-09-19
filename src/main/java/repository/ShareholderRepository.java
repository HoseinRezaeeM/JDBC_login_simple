package repository;

import models.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShareholderRepository {

    private final Connection connection;


    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(Shareholder shareholder)throws SQLException{
        String sql="INSERT INTO shareholder(name, phonenumber, nationacode) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"name");
        preparedStatement.setString(2,"phoneNumber");
        preparedStatement.setString(3,"nationalCode");
        int result =preparedStatement.executeUpdate();
        return result;
    }

}
