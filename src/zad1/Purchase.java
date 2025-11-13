/**
 *
 *  @author Sinior Mateusz S33786
 *
 */

package zad1;


public class Purchase {
    private String customerId;
    private String nameAndSurname;
    private String productName;
    private double price;
    private double amount;

    public Purchase(String customerId, String nameAndSurname, String productName, double price, double amount){
        this.customerId = customerId;
        this.nameAndSurname = nameAndSurname;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }
    public Purchase(String line){
        String[] parts = line.split(";");
        this.customerId = parts[0];
        this.nameAndSurname = parts[1];
        this.productName = parts[2];
        this.price = Double.parseDouble(parts[3]);
        this.amount = Double.parseDouble(parts[4]);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getNameAndSurname(){
        return nameAndSurname;
    }

    public String getProductName(){
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return customerId + ";" + nameAndSurname + ";" + productName + ";" + price + ";" + amount;
    }

    public String toStringWithPrice(){
        double cost = price*amount;
        return toString() + " (koszt: " + cost + ")";
    }
}
