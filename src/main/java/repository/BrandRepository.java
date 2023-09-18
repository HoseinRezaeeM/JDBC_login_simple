package repository;

import models.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BrandRepository {

    private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(Brand brand) throws SQLException {
        String sql="INSERT INTO brand(name, website, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,"name");
        preparedStatement.setString(2,"website");
        preparedStatement.setString(3,"description");
        int result =preparedStatement.executeUpdate();
        return result;
    }
}
