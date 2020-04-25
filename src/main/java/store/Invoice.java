package store;
// William Walsh
// Designed as instructed from book
// Amateur approach to store application
// No Item class created -> Bad design
//


public class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;


    public Invoice() {
        setQuantity(0);
        setPricePerItem(0.00);
    }

    public Invoice(String partUUID, String partDescription, int quantity, double pricePerItem) {
        // Default constructor - Sets defaults for quantity & price
        this();
        setPartUUID(partUUID);
        setPartDescription(partDescription);
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public double getinvoiceAmount() {
        return quantity * pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartUUID(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // 0 is a valid quantity
        if(quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if(pricePerItem >= 0.00) {
            this.pricePerItem = pricePerItem;
        }
    }
}
