package injections.dependency.constructorInjection;

public class Car {
    private final Specification specification;

    public Car(Specification specification) {
        this.specification = specification;
    }

    public void  displayDetails(){
        System.out.println("Car Details :"+specification.toString());
    }
}
