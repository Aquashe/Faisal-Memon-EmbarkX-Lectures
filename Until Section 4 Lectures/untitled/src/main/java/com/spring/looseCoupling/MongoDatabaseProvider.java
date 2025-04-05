package com.spring.looseCoupling;

public class MongoDatabaseProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "Fetching data from MongoDB";
    }
}
