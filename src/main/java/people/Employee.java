package people;

public class Employee extends people.Human {

    private String id;
    private double endOfYearBonus;

    public Employee(String firstName, String lastName, double baseSalary) {
        super(firstName, lastName);
    }

    public Employee(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getEndOfYearBonus() {
        return endOfYearBonus;
    }

    public void setEndOfYearBonus(double endOfYearBonus) {
        this.endOfYearBonus = endOfYearBonus;
    }
}
