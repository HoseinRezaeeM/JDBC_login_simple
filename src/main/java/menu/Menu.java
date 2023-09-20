package menu;

import models.Brand;
import models.Category;
import models.Shareholder;
import models.User;
import service.BrandService;
import service.CategoryService;
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
    private final BrandService brandService=ApplicationContex.getBrandService();
    private final CategoryService categoryService=ApplicationContex.getCategoryService();

    public void firstMenu() throws SQLException {
        System.out.println("\n---------Welcome to MyApplication---------\n");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("Enter your select:");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1 -> login();
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
                        brandMenu();
                    case 3:
                        CategoryMenu();
                    case 4:

                    case 5:
                        System.out.println("----Good Bye---");
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
        System.out.println("3. Delete Shareholder Information :");
        System.out.println("Enter your Select :");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1:
                registerShareholder();
            case 2:
                updateShareholder();
            case 3:
                deleteShareholder();
            default:
                System.out.println("--Error--");
        }

    }

    public void registerShareholder() throws SQLException {
        System.out.println("Enter your name :");
        String name = sc.next();
        System.out.println("Enter your phoneNumber :");
        String phoneNumber = null;
        boolean isTrue = true;
        while (isTrue) {
            phoneNumber=sc.next();
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
            nationalCode=sc.next();
            if (Validation.validationNationalCode(nationalCode)) {
                isTrue1 = false;
            } else {
                System.out.println("please enter a valid nationalCode!!");
            }
        }
        Shareholder shareholder = new Shareholder(null, name, phoneNumber, nationalCode);
        shareholderService.register(shareholder);

    }
    public void updateShareholder() throws SQLException {
        System.out.println("Enter your ID Shareholder :");
        int idShareholder =sc.nextInt();
        shareholderService.update(idShareholder);

    }
    public void deleteShareholder() throws SQLException{
        System.out.println("Enter your IdShareholder :");
        int idShareholder=sc.nextInt();
        shareholderService.delete(idShareholder);
    }

    public void brandMenu() throws SQLException {
        System.out.println("---Brand---");
        System.out.println("1. Add Barnd Information : ");
        System.out.println("2. Add Shareholder Brand :");
        System.out.println("3. Edit Brand Information :");
        System.out.println("4. Delete Brand Information :");
        System.out.println("Enter your Select :");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1:
               registerBrand();
            case 2:
                addShareholderBrand();
            case 3:
                updateBrand();
            case 4:
                deleteBrand();
            default:
                System.out.println("--Error--");
        }

    }

    public void registerBrand() throws SQLException {
        System.out.println("Enter your name :");
        String name = sc.next();
        System.out.println("Enter your website :");
        String website = null;
        boolean isTrue = true;
        while (isTrue) {
            website=sc.next();
            if (Validation.validationWebsite(website)) {
                isTrue = false;
            } else {
                System.out.println("please enter a valid phoneNumber!!");
            }
        }
        System.out.println("Enter your descripton :");
        String description=sc.next();
        Brand brand=new Brand(null,name,website,description);
        brandService.register(brand);


    }
    public void addShareholderBrand() throws SQLException {
        System.out.println("Enter ID Brand :");
        int idBrand=sc.nextInt();
        System.out.println("Enter ID Shareholder :");
        int idShareholder=sc.nextInt();
        brandService.shareholderBranch(idBrand,idShareholder);

    }
    public void updateBrand() throws SQLException {
        System.out.println("Enter your ID Brand :");
        int idBrand =sc.nextInt();
        brandService.update(idBrand);

    }
    public void deleteBrand() throws SQLException{
        System.out.println("Enter your ID Brand :");
        int idBrand=sc.nextInt();
        brandService.delete(idBrand);
    }

    public void CategoryMenu() throws SQLException {
        System.out.println("---Category---");
        System.out.println("1. Add Category Information : ");
        System.out.println("2. Edit Category Information :");
        System.out.println("3. Delete Category Information :");
        System.out.println("Enter your Select :");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
            case 1:
                registerCategory();
            case 2:
                updateCategory();
            case 3:
                deleteCategory();
            default:
                System.out.println("--Error--");
        }

    }

    public void registerCategory() throws SQLException {
        System.out.println("Enter your name :");
        String name = sc.next();
        System.out.println("Enter your descripton :");
        String description=sc.next();
        Category category=new Category(null,name,description);
        categoryService.register(category);


    }
    public void updateCategory() throws SQLException {
        System.out.println("Enter your ID Category :");
        int idCategory =sc.nextInt();
        categoryService.update(idCategory);

    }
    public void deleteCategory() throws SQLException{
        System.out.println("Enter your ID Category :");
        int idCategory=sc.nextInt();
        categoryService.delete(idCategory);
    }


}
