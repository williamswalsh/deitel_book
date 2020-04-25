package store;

import java.util.UUID;

public class InvoiceTest {
    public static void main(String[] args) {


        Invoice inv1 = new Invoice(UUID.randomUUID().toString(), "3d printer", 20, 1000.00);
        Invoice inv2 = new Invoice(UUID.randomUUID().toString(), "MacBook Pro 16\"", 1, 1979.00);
        Invoice inv3 = new Invoice(UUID.randomUUID().toString(), "AI Algorithms", 1, 58.99);

        System.out.println("" + inv1.getQuantity() + " " + inv1.getPartDescription() + " item(s) costs: €" + inv1.getinvoiceAmount());
        System.out.println("" + inv2.getQuantity() + " " + inv2.getPartDescription() + " item(s) costs: €" + inv2.getinvoiceAmount());
        System.out.println("" + inv3.getQuantity() + " " + inv3.getPartDescription() + " item(s) costs: €" + inv3.getinvoiceAmount());
    }
}
