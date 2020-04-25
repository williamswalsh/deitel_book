package sales;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.math.BigInteger;
import java.util.Random;

public class PersonProductMatrix {
    private static Random r = new Random();

    private static SalesSlip createRandomSalesSlip() {
        return new SalesSlip( createRandomSalesPersonNo(), createRandomProductNo(),createRandomDollarAmt());
    }

    private static int createRandomSalesPersonNo(){
        return r.nextInt(2147483647);
    }
    private static int createRandomProductNo(){
        return r.nextInt(5)+1;
    }

    private static double createRandomDollarAmt(){
        // < 500 Dollars
        return (double)r.nextInt(50000) / 100;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(createRandomSalesSlip().getTotalCostOfProductSold());
        }

    }

}


class SalesSlip {
    private int salesPersonNo;
    private int productNo;
    private double totalCostOfProductSold;

    public SalesSlip(int salesPersonNo, int productNo, double totalCostOfProductSold) {
        this.salesPersonNo = salesPersonNo;
        this.productNo = productNo;
        this.totalCostOfProductSold = totalCostOfProductSold;
    }

    public int getSalesPersonNo() {
        return salesPersonNo;
    }

    public int getProductNo() {
        return productNo;
    }

    public double getTotalCostOfProductSold() {
        return totalCostOfProductSold;
    }
}
