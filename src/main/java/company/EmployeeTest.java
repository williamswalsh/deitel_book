package company;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee e1 = new Employee( "William", "Walsh", 35000.00);
        Employee e2 = new Employee( "Peter", "Griffin", 60000.00);
        Employee e3 = new Employee( "Ciaran", "Mckenna", 100000.00);

        e1.applyRaisePercentage(14.2859);
        e2.applyRaisePercentage(16);
        e3.applyRaisePercentage(17);

        String printStr = "Employee: %s %s, Salary: %.2f\n";
        System.out.printf( printStr, e1.getFirstName(), e1.getLastName(), e1.getSalary() );
        System.out.printf( printStr, e2.getFirstName(), e2.getLastName(), e2.getSalary() );
        System.out.printf( printStr, e3.getFirstName(), e3.getLastName(), e3.getSalary() );
    }
}
