package utility;

import connection.JdbcConnetion;
import repository.ShareholderRepository;
import repository.UserRepository;
import service.ShareholderService;
import service.UserService;

import java.sql.Connection;

public class ApplicationContex {

    private final static Connection CONNECTION;
    private final static UserRepository USER_REPOSITORY;
    private final static UserService USER_SERVICE;
    private final static ShareholderRepository SHAREHOLDER_REPOSITORY;
    private final static ShareholderService SHAREHOLDER_SERVICE;

    static {
        CONNECTION =JdbcConnetion.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE =new UserService(USER_REPOSITORY);
        SHAREHOLDER_REPOSITORY=new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE=new ShareholderService(SHAREHOLDER_REPOSITORY);

    }
    public static UserService getUserService(){
        return USER_SERVICE;
    }
    public static ShareholderService getShareholderService(){return SHAREHOLDER_SERVICE;}



}
