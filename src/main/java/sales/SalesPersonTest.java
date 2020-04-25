package sales;

import java.util.ArrayList;
import java.util.List;

public class SalesPersonTest {
    public static void main(String[] args) {

        Item a = new Item("Bike", 200.00);
        Item b = new Item("Kite", 50.00);
        Item c = new Item("Laptop", 1200.00);

        List<Item> items = new ArrayList<>();
        items.add(a);
        items.add(b);
        items.add(c);

        SalesPerson s1 = new SalesPerson("John Pio", "O' Grourke", items);
        s1.setCommissionRate(0.09);
        //s1.setBasesalary(0.00);
        System.out.printf("Sales Person: %s %s, Total Salary: %.2f",s1.getFirstName(), s1.getLastName(), s1.calcSalary());
    }
}
