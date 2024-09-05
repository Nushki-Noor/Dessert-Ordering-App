package Adapters;

public class UserClass {

private String Username;

private String Password;

private String UserType;

public UserClass(){}

    public UserClass(String username, String password) {
        Username = username;
        Password = password;
    }

    public UserClass(String username, String password, String userType) {
        Username = username;
        Password = password;
        UserType = userType;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
