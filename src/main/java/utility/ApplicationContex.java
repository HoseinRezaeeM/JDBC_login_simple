package utility;

import connection.JdbcConnetion;
import repository.BrandRepository;
import repository.CategoryRepository;
import repository.ShareholderRepository;
import repository.UserRepository;
import service.BrandService;
import service.CategoryService;
import service.ShareholderService;
import service.UserService;

import java.sql.Connection;

public class ApplicationContex {

    private final static Connection CONNECTION;
    private final static UserRepository USER_REPOSITORY;
    private final static UserService USER_SERVICE;
    private final static ShareholderRepository SHAREHOLDER_REPOSITORY;
    private final static ShareholderService SHAREHOLDER_SERVICE;
    private final static BrandRepository BRAND_REPOSITORY;
    private final static BrandService BRAND_SERVICE;
    private final static CategoryRepository CATEGORY_REPOSITORY;
    private final static CategoryService CATEGORY_SERVICE;

    static {
        CONNECTION =JdbcConnetion.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE =new UserService(USER_REPOSITORY);
        SHAREHOLDER_REPOSITORY=new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE=new ShareholderService(SHAREHOLDER_REPOSITORY);
        BRAND_REPOSITORY=new BrandRepository(CONNECTION);
        BRAND_SERVICE=new BrandService(BRAND_REPOSITORY);
        CATEGORY_REPOSITORY=new CategoryRepository(CONNECTION);
        CATEGORY_SERVICE=new CategoryService(CATEGORY_REPOSITORY);

    }
    public static UserService getUserService(){
        return USER_SERVICE;
    }
    public static ShareholderService getShareholderService(){return SHAREHOLDER_SERVICE;}
    public static BrandService getBrandService(){
        return BRAND_SERVICE;
    }
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}



}
