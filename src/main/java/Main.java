/**
 * Entry point added so the project can be run with `gradle run`.
 * The original E-Commerce3 classes are unchanged.
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("C001", "Jane Doe", "jane@example.com", "555-0100",
                "123 Main St", "Erie", "PA", "16501", "USA", "GOLD");

        Order order = new Order("ORD-1001", customer, 1);
        order.addItem(new OrderItem(new Item("I-1", "Laptop", 899.99, 2.0, "ELECTRONICS"), 1));
        order.addItem(new OrderItem(new Item("I-2", "Novel", 15.50, 0.5, "BOOKS"), 2));
        order.addItem(new OrderItem(new Item("I-3", "Vase", 40.00, 1.5, "FRAGILE"), 1));

        DiscountManager discounts = new DiscountManager();
        ShippingService shipping = new ShippingService();
        NotificationService notifications = new NotificationService();

        System.out.printf("Raw subtotal:        $%.2f%n", order.calculateRawSubtotal());
        System.out.printf("After tier discount: $%.2f%n", discounts.applyTierDiscount(order));
        System.out.printf("Invoice w/ tax:      $%.2f%n", discounts.calculateInvoiceTotalWithTax(order));
        System.out.printf("Shipping cost:       $%.2f%n", shipping.calculateShippingCost(order));
        System.out.println();
        System.out.print(shipping.generateShippingLabel(order));
        System.out.println();
        notifications.sendOrderConfirmation(order, "EMAIL");
    }
}
