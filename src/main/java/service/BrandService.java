package service;

import models.Brand;
import repository.BrandRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {

    private final BrandRepository brandRepository;
    private final Scanner scanner=new Scanner(System.in);

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public void register(Brand brand) throws SQLException {
        int result=brandRepository.save(brand);
        if(result!=0){
            System.out.println(brand.getName()+" successfully added to database");
        }
        else {
            System.out.println("--Error404--");
        }
    }
    public void update(int idBrand) throws SQLException {
        System.out.println("Enter name:");
        String name=scanner.next();
        System.out.println("Enter website :");
        String website =scanner.next();
        System.out.println("Enter description:");
        String desccription=scanner.next();
        int result =brandRepository.update(name,website,desccription,idBrand);
        if(result!=0){
            System.out.println("successfully deleted from database");
        }
        else {
            System.out.println("--Error404--");
        }
    }
    public void delete(int idBrand) throws SQLException {
        int result =brandRepository.delete(idBrand);
        if (result != 0) {
            System.out.println("successfully deleted from database");
        } else {
            System.out.println("---Eror404--");
        }
    }

}
