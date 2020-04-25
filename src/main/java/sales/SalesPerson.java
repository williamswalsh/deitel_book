package sales;

import java.util.List;

public class SalesPerson extends people.Employee implements people.Salaried {

    private List<Item> soldItems;
    private double commissionRate;

    public SalesPerson(String firstName, String lastName, List<Item> soldItems) {
        super(firstName, lastName);
        this.soldItems = soldItems;
    }

    public SalesPerson(String firstName, String lastName, int age, List<Item> soldItems) {
        super(firstName, lastName, age);
        this.soldItems = soldItems;
    }

    public SalesPerson(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public SalesPerson(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public List<Item> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(List<Item> soldItems) {
        this.soldItems = soldItems;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double calcSalary() {
//        double itemTotalValue = 0.0;
//
//        for (Item item : soldItems) {
//            itemTotalValue += item.getValue();
//        }
//        return this.getBasesalary() + (this.getCommissionRate() * itemTotalValue);
        return 0.0;
   }
}
