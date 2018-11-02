package com.geek.geekblog.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.geek.geekblog.Models.ResponseUser;

public class SessionManager {
    private static SharedPreferences sharedPreferences;
    private static final String sharedpreferenceName = "ChatApp_data";
    public static void LoginUser(Context ctx, ResponseUser user){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loggedIn",true);
        editor.putInt("id",user.id);
        editor.putString("username",user.user_name);
        editor.putString("email",user.user_email);
        editor.apply();
    }
    public static boolean isLoggedIn(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("loggedIn",false);
    }
    public static int getUserId(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id",0);
    }
    public static String getUserName(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        return sharedPreferences.getString("username",null);
    }
    public static String getUserEmail(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        return sharedPreferences.getString("email",null);
    }
    public static void LogOut(Context ctx){
        sharedPreferences = ctx.getSharedPreferences(sharedpreferenceName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("loggedIn",false);
        editor.apply();
    }
}
