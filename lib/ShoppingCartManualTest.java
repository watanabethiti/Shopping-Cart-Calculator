package lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }


    // Test 3: คำนวณปกติ ไม่มีส่วนลด
    ArrayList<CartItem> simpleCart = new ArrayList<>();
    simpleCart.add(new CartItem("NORMAL", "Soda", 25.0, 2)); // 50
    simpleCart.add(new CartItem("NORMAL", "Water", 15.0, 1));      // 15
    double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
      if (total3 == 65.0) {
        System.out.println("PASSED: Simple cart total is correct (65.0)");
                    passedCount++;
    } else {
        System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
        failedCount++;
                }

    // Test 4 : ทำตามส่วนลด BOGO (ซื้อ1แถม1)ตามส่วนลด
          ArrayList<CartItem> FreeCart = new ArrayList<>();
            FreeCart.add(new CartItem("BOGO", "Bread", 45.0, 3)); // 45*2=90 freee 1
            FreeCart.add(new CartItem("BOGO", "Burger", 70.0, 2));      // 70 free 1
            double total4 = ShoppingCartCalculator.calculateTotalPrice(FreeCart);
            if (total4 == 160.0) {
              System.out.println("PASSED: Free cart total is correct (160.0)");
                passedCount++;
        } else {
                 System.out.println("FAILED: Free cart total expected 160.0 but got " + total4);
                    failedCount++;
                }

      // Test 5 : ทำตามส่วนลด BULK (ซื้อ>= 6 ชิ้นลด10% )ซื้อสินค้าทั้งหมดที่วางโปรไว้
          ArrayList<CartItem> DiscountCart = new ArrayList<>();
          DiscountCart.add(new CartItem("BULK", "Juice", 15.0, 9)); // 135-13.5 == 121.5
          DiscountCart.add(new CartItem("BULK", "Popcorn", 35.0, 6));   // 210-21 ==189
          double total5 = ShoppingCartCalculator.calculateTotalPrice(DiscountCart);
          if (total5 == 310.5) {
            System.out.println("PASSED: Discount cart total is correct (310.5)");
              passedCount++;
      } else {
               System.out.println("FAILED: Discount cart total expected 310.5 but got " + total5);
                  failedCount++;
              }


        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}