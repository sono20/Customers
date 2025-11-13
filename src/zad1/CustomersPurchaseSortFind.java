package zad1;

import java.io.*;
import java.util.*;


public class CustomersPurchaseSortFind implements Comparator<Purchase>{
    public CustomersPurchaseSortFind() {
        this.purchases = new ArrayList<>();
    }
    private List<Purchase> purchases;
    private String sortType;
    public List<Purchase> readFile(String filename) {
        if(purchases != null) {
            purchases.clear();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    purchases.add(new Purchase(line));
                }
            }
            return purchases;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showSortedBy(String sortType){
        this.sortType = sortType;
        List<Purchase> sorted = new ArrayList<>(purchases);
        Collections.sort(sorted,this);
        if(sortType.equals("Koszty")){
            System.out.println("Koszty");
            sorted.forEach(p -> System.out.println(p.toStringWithPrice()));
        }else{
            System.out.println("Nazwiska");
            sorted.forEach(System.out::println);
        }
        System.out.println();
    }
    public void showPurchaseFor(String id){
         System.out.println("Klient " + id);
         purchases.stream()
                 .filter(p->p.getCustomerId().equals(id))
                 .forEach(System.out::println);
        System.out.println();
    }


    @Override
    public int compare(Purchase o1, Purchase o2){
        if(sortType.equals("Nazwiska")){
            int nameComparison = o1.getNameAndSurname().compareTo(o2.getNameAndSurname());
            if (nameComparison != 0){
                return nameComparison;
            }
            return o1.getCustomerId().compareTo(o2.getCustomerId());
    } else if (sortType.equals("Koszty")){
            int priceComparison = Double.compare(o2.getPrice(),o1.getPrice());
            if (priceComparison != 0){
                return priceComparison;
            }
            return o1.getCustomerId().compareTo(o2.getCustomerId());
        }
        return 0;
    }
}
