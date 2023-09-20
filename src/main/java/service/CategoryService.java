package service;

import models.Category;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final Scanner scanner = new Scanner(System.in);

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void register(Category category) throws SQLException {
        int result = categoryRepository.save(category);
        if (result != 0) {
            System.out.println(category.getName() + " successfully added to database");
        } else {
            System.out.println("--Error404--");
        }
    }

    public void update(int idCategory) throws SQLException {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter description:");
        String desccription = scanner.next();
        int result = categoryRepository.update(name, desccription, idCategory);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("--Error404--");
        }
    }

    public void delete(int idCategory) throws SQLException {
        int result = categoryRepository.delete(idCategory);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("---Eror404--");
        }
    }
}


