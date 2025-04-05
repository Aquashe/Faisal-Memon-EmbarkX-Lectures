package componentScan.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Appconfig.class);
        Employee emp = context.getBean("employee", Employee.class);
        System.out.println(emp.toString());
    }
}
