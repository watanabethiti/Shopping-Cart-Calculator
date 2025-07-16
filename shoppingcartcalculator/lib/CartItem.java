package lib ;

import java.util.ArrayList;

public record CartItem(String sku, String name, double price, int quantity){

    public class InnerCartItem {
    private ArrayList<CartItem> ct = new ArrayList<>();
    public void additem(CartItem item) {
        ct.add(item);
    }

 public  ArrayList<CartItem> getitem(){
    return ct ;
 }



 }


    

}