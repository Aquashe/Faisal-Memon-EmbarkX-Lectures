package com.spring.looseCoupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCouplingExample {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.looseCoupling.xml");
        UserManager userManagerDatabase = (UserManager) context.getBean("userManagerDataBaseProvider");
        System.out.println(userManagerDatabase.getUserInfo());

        UserManager userManagerWebService = (UserManager) context.getBean("userManagerWebServiceProvider");
        System.out.println(userManagerWebService.getUserInfo());

        UserManager userManagerMongoDatabase = (UserManager) context.getBean("userManagerMongoDataBaseProvider");
        System.out.println(userManagerMongoDatabase.getUserInfo());
    }
}
