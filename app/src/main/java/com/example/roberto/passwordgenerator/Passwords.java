package com.example.roberto.passwordgenerator;

/**
 * Created by joshua on 3/17/2016.
 */
public class Passwords {

    private String Password;
    private String Name;

    public void Passwords(String pass, String name){
        Password = pass;
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
