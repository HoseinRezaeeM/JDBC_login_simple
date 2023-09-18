package menu;

import models.User;
import service.UserService;
import utility.ApplicationContex;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final UserService userService = ApplicationContex.getUserService();

    public void firstMenu() throws SQLException {
        System.out.println("\n---------Welcome to MyApplication---------\n");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("Enter your select:");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1 -> System.out.println("");
            case 2 -> register();
            case 3 -> System.out.println("exit");
            default -> System.out.println("---Eror404---");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter your name: ");
        String name =sc.next();
        System.out.println("Enter your UserName: ");
        String userName =sc.next();
        System.out.println("Enter your Email : ");
        String email=null;
        boolean isboolean=true;
        while (isboolean){
            email = sc.next();
            if(Validation.validationEmail(email))
                isboolean =false;
            else
                System.out.println("please enter a valid Email");
        }
        System.out.println("Enter your password : ");
        String password = null;
        boolean flag=true;
        while (flag){
            if(Validation.validationPassword(password))
                flag =false;
            else
                System.out.println("please enter a valid password");
        }

        User user =new User(null,name,userName,email,password);
        userService.register(user);
    }



}
