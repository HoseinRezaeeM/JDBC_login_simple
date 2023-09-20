package repository;

import models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryRepository {

    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }
    public int save(Category category) throws SQLException {
        String sql="INSERT INTO category(name, description) VALUES (?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        int result =preparedStatement.executeUpdate();
        return result;
    }
    public int update(String name,String description,int idCategory) throws SQLException {
        String sql="UPDATE category SET name=?,description=? WHERE idcategory=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,description);
        preparedStatement.setInt(3,idCategory);
        int result =preparedStatement.executeUpdate();
        return result;
    }
    public int delete(int idCategory)throws SQLException {
        String sql = "DELETE FROM brand where idbrand=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,idCategory);
        int result =preparedStatement.executeUpdate();
        return result;

    }
}
