package com.tight.coupling;

public class UserManager {
    UserDatabase userDatabase = new UserDatabase();
    public  String getUserInfo(){
        return  userDatabase.getUserDetails();
    }
}
