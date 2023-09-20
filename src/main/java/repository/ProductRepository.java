package repository;

import models.Brand;
import models.Category;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class ProductRepository {

    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public void loadAll() throws SQLException {
        String sqlBrand ="SELECT * FROM brand";
        String sqlCategory="SELECT * FROM category";
        PreparedStatement preparedStatement=connection.prepareStatement(sqlBrand);
        PreparedStatement preparedStatement1=connection.prepareStatement(sqlCategory);
        ResultSet resultSet =preparedStatement.executeQuery();
        ResultSet resultSet1=preparedStatement1.executeQuery();

        Brand[] brands=new Brand[10];
        Category[] categories=new Category[10];
        int i=0;

        while (resultSet.next()){
            brands[i]=new Brand(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
                    );
            i++;
        }
        System.out.println(Arrays.toString(brands)+"\n");

        while (resultSet1.next()){
            categories[i]=new Category(
                    resultSet1.getInt(1),
                    resultSet1.getString(2),
                    resultSet1.getString(3)
            );
            i++;
        }
        System.out.println(Arrays.toString(categories));
    }
    public int save(Product product) throws SQLException {
        String sql = "INSERT INTO product(name,createdate,idcategory,idbrand) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3, product.getIdBrand());
        preparedStatement.setInt(4,product.getIdCategory());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int update(String name, String createDate, int idCategory, int idBrand) throws SQLException {
        String sql = "UPDATE product SET name=?,createdate=?,idcategory=?,idbrand=? WHERE idproduct=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, createDate);
        preparedStatement.setInt(3, idCategory);
        preparedStatement.setInt(4, idBrand);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int idProduct) throws SQLException {
        String sql = "DELETE FROM product where idproduct=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idProduct);
        int result = preparedStatement.executeUpdate();
        return result;

    }

}
