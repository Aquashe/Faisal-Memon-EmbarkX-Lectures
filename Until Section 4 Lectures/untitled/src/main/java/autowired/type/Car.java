package autowired.type;

public class Car {
    private Specification specification;


    public void  displayDetails(){
        System.out.println("Car Details :"+specification.toString());
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }
}
