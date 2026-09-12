import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("||         MENU         ||");
        System.out.println("==========================");
        System.out.println("|| 1. Shawarma - $75.00 ||");
        System.out.println("|| 2. Hotdog   - $65.00 ||");
        System.out.println("|| 3. Egg Pie  - $35.00 ||");
        System.out.println("|| 4. Fries    - $25.00 ||");
        System.out.println("|| 5. Coke     - $10.00 ||");
        System.out.println("==========================");
            
        int totalQuantity = 0;
        double totalBeforeDiscount = 0.0;
        double totalDiscount = 0.0;
        boolean orderAgain = true;
            
        while (orderAgain) {
            System.out.print("Enter the item number (1-5): ");
            int itemNumber = scanner.nextInt();
                
            System.out.print("Enter the quantity of your order (1-10): ");
            int quantity = scanner.nextInt();
            
            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");  
            } else {
                System.out.print("Are you a student? (Y/N): ");
            
                char studentAnswer = scanner.next().toUpperCase().charAt(0);
                
                boolean isStudent = (studentAnswer == 'Y');
            
                double price = 0.0;
            
                switch (itemNumber) {
                    case 1:
                        price = 75.00;
                        break;
                    case 2:
                        price = 65.00;
                        break;
                    case 3:
                        price = 35.00;
                        break;
                    case 4:
                        price = 25.00;
                        break;
                    case 5:
                        price = 10.00;
                        break;
                }

                double subtotal = price * quantity;

                double discountRate = 0.0;
                if (isStudent && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (subtotal >= 500) {
                    discountRate = 0.05;
                } else if (isStudent) {
                    discountRate = 0.10;
                } else {
                    discountRate = 0.0;
                }

                double orderDiscount = subtotal * discountRate;
                double orderTotal = subtotal - orderDiscount;

                System.out.println();
                System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
                System.out.println("Discount: $" + String.format("%.2f", orderDiscount));
                System.out.println("Order total: $" + String.format("%.2f", orderTotal));

                totalQuantity += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += orderDiscount;
            }
            System.out.print("\nDo you want to order again? (Y/N): ");
            char orderAgainAnswer = scanner.next().toUpperCase().charAt(0);
                
            if (orderAgainAnswer != 'Y') {
                orderAgain = false;
            }
            System.out.println();
        }   

        double finalAmount = totalBeforeDiscount - totalDiscount;
            
        System.out.println("=========================================");
        System.out.println("||               SUMMARY               ||");
        System.out.println("=========================================");
        System.out.printf("|| Total Quantity of Items : %-5d     ||%n", totalQuantity);
        System.out.printf("|| Total Before Discount   : $%-8.2f ||%n", totalBeforeDiscount);
        System.out.printf("|| Total Discount          : $%-8.2f ||%n", totalDiscount);
        System.out.println("-----------------------------------------");
        System.out.printf("|| Final Amount            : $%-8.2f ||%n", finalAmount);
        System.out.println("=========================================");
        
        scanner.close();
    }
}