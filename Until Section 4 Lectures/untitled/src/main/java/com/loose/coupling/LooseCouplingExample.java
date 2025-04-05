package com.loose.coupling;

public class LooseCouplingExample {
    public static void main(String[] args) {
        UserDataProvider userDatabaseProvider = new UserDatabaseProvider();
        UserManager userManagerDatabaseProvider = new UserManager(userDatabaseProvider);
        System.out.println(userManagerDatabaseProvider.getUserInfo());

        UserDataProvider userWebserviceProvider = new WebServiceDataProvider();
        UserManager userManagerWebserviceProvider = new UserManager(userWebserviceProvider);
        System.out.println(userManagerWebserviceProvider.getUserInfo());

        UserDataProvider userMongoDbProvider = new MongoDatabaseProvider();
        UserManager userManagerMongoDbProvider = new UserManager(userMongoDbProvider);
        System.out.println(userManagerMongoDbProvider.getUserInfo());
    }
}
