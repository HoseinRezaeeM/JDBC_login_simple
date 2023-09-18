package models;

public class User {
    private Integer idUser;
    private String name;
    private String userName;
    private String password;

    public User(Integer idUser, String name, String userName, String password) {
        this.idUser = idUser;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
