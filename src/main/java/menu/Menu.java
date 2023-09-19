package menu;

import models.Shareholder;
import models.User;
import service.ShareholderService;
import service.UserService;
import utility.ApplicationContex;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final UserService userService = ApplicationContex.getUserService();
    private final ShareholderService shareholderService = ApplicationContex.getShareholderService();

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
            case 2 -> registerUser();
            case 3 -> System.out.println("exit");
            default -> System.out.println("---Eror404---");
        }
    }

    public void registerUser() throws SQLException {
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your UserName: ");
        String userName = sc.next();
        System.out.println("Enter your Email : ");
        String email = null;
        boolean isboolean = true;
        while (isboolean) {
            email = sc.next();
            if (Validation.validationEmail(email))
                isboolean = false;
            else
                System.out.println("please enter a valid Email");
        }
        System.out.println("Enter your password : ");
        String password = null;
        boolean flag = true;
        while (flag) {
            if (Validation.validationPassword(password))
                flag = false;
            else
                System.out.println("please enter a valid password");
        }

        User user = new User(null, name, userName, email, password);
        userService.register(user);
    }

    public void login() throws SQLException {
        System.out.println("Enter UserName :");
        String userName = sc.next();
        System.out.println("Enter Password : ");
        String password = sc.next();
        User user = userService.login(userName);
        if (user == null && !user.getPassword().equals(password)) {
            System.out.println("you enter a username and password incorrect!!!");
        } else {
            boolean isBolean = true;
            while (isBolean) {
                System.out.println("-------Welcome------");
                System.out.println("1. Shareholder ");
                System.out.println("2. Brand ");
                System.out.println("3. Category ");
                System.out.println("4. Product ");
                System.out.println("5. Exit ");
                System.out.println("Enter your select :");
                int select = sc.nextInt();
                switch (select) {
                    case 1:
                        shareholderMenu();
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    default:
                        System.out.println("-----Error404----");

                }
            }
        }
    }

    public void shareholderMenu() throws SQLException {
        System.out.println("---Shareholder---");
        System.out.println("1. Add Shareholer Information : ");
        System.out.println("2. Edit Shareholder Information :");
        System.out.println("2. Delete Shareholder Information :");
        System.out.println("Enter your Select :");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1:
                registerShareholder();
            case 2:

        }

    }

    public void registerShareholder() throws SQLException {
        System.out.println("Enter your name :");
        String name = sc.next();
        System.out.println("Enter your phoneNumber :");
        String phoneNumber = null;
        boolean isTrue = true;
        while (isTrue) {
            if (Validation.validatePhoneNumber(phoneNumber)) {
                isTrue = false;
            } else {
                System.out.println("please enter a valid phoneNumber!!");
            }
        }
        System.out.println("Enter your nationalCode :");
        String nationalCode = null;
        boolean isTrue1 = true;
        while (isTrue1) {
            if (Validation.validationNationalCode(nationalCode)) {
                isTrue1 = false;
            } else {
                System.out.println("please enter a valid nationalCode!!");
            }
        }
        Shareholder shareholder = new Shareholder(null, name, phoneNumber, nationalCode);
        shareholderService.register(shareholder);

    }


}
