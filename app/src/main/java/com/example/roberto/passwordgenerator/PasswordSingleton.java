package com.example.roberto.passwordgenerator;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by joshua on 3/17/2016.
 */
public class PasswordSingleton {

    private ArrayList<Passwords> mPasswords;
    private static PasswordSingleton sPasswordSingleton = null;
    private Context mContext;

    private PasswordSingleton(Context appContext){
        mContext = appContext;
        mPasswords = new ArrayList<Passwords>();

    }

    public ArrayList<Passwords> getPasswords(){
        return mPasswords;
    }

    public static PasswordSingleton get(Context c){
        if(sPasswordSingleton == null){
            sPasswordSingleton = new PasswordSingleton(c.getApplicationContext());
        }
        return sPasswordSingleton;
    }

    public void addPassword(Passwords p){
        mPasswords.add(p);
    }

}
