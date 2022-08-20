package com.example.asp.roomly_one;

import android.content.SharedPreferences;
import android.content.Context;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences usersSession ;
    SharedPreferences.Editor editor;
    Context context;

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String Key_name = "name";
    public static final String Key_email = "email";
    public static final String Key_phone = "phone";
    public static final String Key_password = "pasword";

    public SessionManager (Context _context){
        context = _context;
        usersSession = _context.getSharedPreferences("userLoginSession",Context.MODE_PRIVATE);
        editor = usersSession.edit();
    }

    public void createLoginSession(String name, String email, String phone, String pasword){

        editor.putBoolean(IS_LOGIN,true);
        editor.putString(Key_name,name);
        editor.putString(Key_email,email);
        editor.putString(Key_phone,phone);
        editor.putString(Key_password,pasword);

        editor.commit();
    }

    public HashMap<String, String> getUsersDetailFromSession(){
        HashMap<String,String> userData = new HashMap<String,String>();
        
        userData.put(Key_name, usersSession.getString(Key_name, null));
        userData.put(Key_email, usersSession.getString(Key_email, null));
        userData.put(Key_phone, usersSession.getString(Key_phone, null));
        userData.put(Key_password, usersSession.getString(Key_password, null));

        return userData;
    }

    public boolean checkLogin(){
        if(usersSession.getBoolean(IS_LOGIN,true))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public void logoutUserFromSession(){
        editor.clear();
        editor.commit();
    }


}
