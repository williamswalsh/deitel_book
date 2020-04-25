package main_pkg;

import people.WageEmployee;

public class MainTestArea {
    public static void main(String[] args) {
        people.WageEmployee emp1 = new WageEmployee("John", "Walsh", 1.00);
        people.WageEmployee emp2 = new WageEmployee("Donal", "Walsh", 1.00);

        emp1.setHoursWorked(40);
        emp2.setHoursWorked(41);

        System.out.printf("Employee: %s %s, Total wage: %.2f\n",emp1.getFirstName(), emp1.getLastName(), emp1.calcWeekWage());
        System.out.printf("Employee: %s %s, Total wage: %.2f\n",emp2.getFirstName(), emp2.getLastName(), emp2.calcWeekWage());
    }
}
