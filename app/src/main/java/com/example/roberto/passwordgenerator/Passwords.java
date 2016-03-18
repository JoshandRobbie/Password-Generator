package com.example.roberto.passwordgenerator;

/**
 * Created by joshua on 3/17/2016.
 */
public class Passwords {

    private String Password;
    private String UserName;
    private String Website;

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void Passwords(String pass, String name,String Web){
        Password = pass;
        Website = Web;
        UserName = name;


    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
