package lib;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     # จะทำอย่างไรถ้า items เป็น null หรือ empty? 
       return ค่าเป็น 0.0
     # กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
       เช็คsku แล้วเช็คจำนวนสินค้าถ้าตรงตามจำนวนที่โปรโมชั่นกำหนดจะนำไปคำนวณ
     # กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
       เช็คsku เช็คแล้วจำนวนสินค้าถ้ามากกว่า6ชิ้นจพคำนวณตามโปรโมชั่นที่กำหนด
       @param items รายการสินค้าที่อยู่ในตะกร้า ({ArrayList<CartItem>}) โดยแต่ละ {CartItem} มีคุณสมบัติดังนี้
                    * price ราคาของสินค้า
                    * quantity จำนวนสินค้าที่ต้องการ (ต้องไม่ติดลบ) 
                    * sku ประเภทโปรสินค้า ได้แก่ "BULK","BOGO","NORMAL" 
                    * name ชื่อสินค้าต้อง (ห้ามเป็นค่าว่าง)
     * @return ยอดรวมราคาทั้งหมดหลังคิดส่วนลด ถ้า input ไม่ถูกต้อง จะ return 0.0
       

     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        
        double total = 0;
        String namesku[] = {"BULK","BOGO","NORMAL"};
        if (items == null || items.isEmpty()){
            return 0.0;
        }
       for (CartItem item : items){
        if (item.price()<=0 || item.quantity()<=0 || !(Arrays.asList(namesku).contains(item.sku().toUpperCase()))){
            return 0.0 ;
        }
        if (item.sku().equalsIgnoreCase("BULK")){
            if (item.quantity()>=6){
                total += (item.price()*item.quantity()) - (item.price()*item.quantity()*10.0/100.0);
            } else total += item.price()*item.quantity();
        }
        else if (item.sku().equalsIgnoreCase("BOGO")){
            total += item.price()*(Math.ceil((item.quantity()/2.0)));
        }
        else {total +=item.price()*item.quantity();}
       }
        return total;
    }
}