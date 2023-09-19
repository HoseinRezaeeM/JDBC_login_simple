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

    public int save(Shareholder shareholder) throws SQLException {
        String sql = "INSERT INTO shareholder(name, phonenumber, nationacode) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "name");
        preparedStatement.setString(2, "phoneNumber");
        preparedStatement.setString(3, "nationalCode");
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int updateInfoShareholder(String name, String phoneNumber, String nationalCode, int idShareholer) throws SQLException {
        String sql ="UPDATE shareholder SET name=?, phonenumber=?, nationacode=? WHERE idshareholder=?";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,phoneNumber);
        preparedStatement.setString(3,nationalCode);
        preparedStatement.setInt(4,idShareholer);
        int result =preparedStatement.executeUpdate();
        return result;


    }
    public int delete(int idShareholder)throws SQLException{
        String sql="DELETE FROM shareholder WHERE idshareholder=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,idShareholder);
        int result=preparedStatement.executeUpdate();
        return result;

    }

}
