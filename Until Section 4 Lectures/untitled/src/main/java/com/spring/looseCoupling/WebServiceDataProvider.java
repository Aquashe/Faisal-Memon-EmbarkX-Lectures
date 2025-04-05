package com.spring.looseCoupling;

public class WebServiceDataProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "Fetching data From Web Service";
    }
}
