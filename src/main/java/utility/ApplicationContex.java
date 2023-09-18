package utility;

import connection.JdbcConnetion;
import repository.UserRepository;
import service.UserService;

import java.sql.Connection;

public class ApplicationContex {

    private final static Connection CONNECTION;
    private final static UserRepository USER_REPOSITORY;
    private final static UserService USER_SERVICE;

    static {
        CONNECTION =JdbcConnetion.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE =new UserService(USER_REPOSITORY);

    }
    public static UserService getUserService(){
        return USER_SERVICE;
    }



}
