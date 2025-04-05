package componentScan.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.componentScan.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee.toString());
    }
}
