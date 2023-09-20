package repository;

import models.Brand;
import models.Category;

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
        System.out.println(Arrays.toString(brands));

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
}
