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
        String sql = "INSERT INTO brand(name, website, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "name");
        preparedStatement.setString(2, "website");
        preparedStatement.setString(3, "description");
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String website, String description, int idBrand) throws SQLException {
        String sql = "UPDATE brand SET name=?,website=?,description=? WHERE idbrand=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, website);
        preparedStatement.setString(3, description);
        preparedStatement.setInt(4, idBrand);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int idBrand) throws SQLException {
        String sql = "DELETE FROM brand where idbrand=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idBrand);
        int result = preparedStatement.executeUpdate();
        return result;

    }

    public int shareholderBrand(int idBrand, int idShareholder) throws SQLException {
        String sql = "INSERT INTO sharehoderbrand(idbarand, idshareholder) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idBrand);
        preparedStatement.setInt(2, idShareholder);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
