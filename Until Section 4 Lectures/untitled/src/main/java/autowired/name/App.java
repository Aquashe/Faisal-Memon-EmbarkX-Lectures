package autowired.name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.autowired.name.xml");
        Car car = (Car) context.getBean("myCar");
        car.displayDetails();
    }
}
