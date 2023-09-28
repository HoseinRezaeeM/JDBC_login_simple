package service;

import models.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    private final ProductRepository prouductRepository;
    private final Scanner scanner = new Scanner(System.in);

    public ProductService(ProductRepository prouductRepository) {
        this.prouductRepository = prouductRepository;
    }

    public void loadAll() throws SQLException {
        prouductRepository.loadAll();
    }

    public void register(Product product) throws SQLException {
        int result = prouductRepository.save(product);

        if (result != 0) {
            System.out.println(product.getName() + " successfully added to database");
        } else {
            System.out.println("--Error404--");
        }
    }

    public void update(int idProduct) throws SQLException {
        System.out.println("Enter new name:");
        String name = scanner.next();
        System.out.println("Enter new CreateDate :");
        String createDate = scanner.next();
        System.out.println("Enter idCategory:");
        int idCategory = scanner.nextInt();
        System.out.println("Enter idBrand :");
        int idBrand = scanner.nextInt();
        int result = prouductRepository.update(name, createDate, idCategory, idBrand,idProduct);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("--Error404--");
        }
    }

    public void delete(int idProduct) throws SQLException {
        int result = prouductRepository.delete(idProduct);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("---Eror404--");
        }
    }


}
