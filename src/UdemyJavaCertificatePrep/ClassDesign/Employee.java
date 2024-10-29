package ClassDesign;

public class Employee implements Academic, Employable {
    @Override
    public void study() {
        System.out.println("Study! Study! Study!");
    }
}
