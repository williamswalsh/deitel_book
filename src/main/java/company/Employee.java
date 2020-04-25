package company;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0.00) {
            this.salary = salary;
        }
    }

    // Takes integer that represents dividend in percentage 10 -> 10/100 -> 10%
    public void applyRaisePercentage ( double raisePercentage ){
        if ( raisePercentage > 0 ) {
            double raiseAmt = getSalary() * (raisePercentage / 100);
            setSalary(getSalary() + raiseAmt);
        }
    }
}
