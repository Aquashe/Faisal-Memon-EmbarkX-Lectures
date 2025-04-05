package com.spring.looseCoupling;

public class UserDatabaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails(){
        return  "User Details from Database";
    }
}
