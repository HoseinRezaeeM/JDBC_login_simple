package service;


import models.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final UserRepository userRepository;
    Scanner scanner = new Scanner(System.in);


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) throws SQLException {
        int result =userRepository.save(user);
        if (result != 0)
            System.out.println(user.getName() + " successfully added to database");
        else
            System.out.println("OOps! :(");
    }

    public User login(String userName) throws SQLException {
        User user = userRepository.login(userName);
        return user;
    }

}
