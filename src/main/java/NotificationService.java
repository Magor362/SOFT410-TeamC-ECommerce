public class NotificationService {

    public void sendOrderConfirmation(Order order, String channel) {
        Customer c = order.getCustomer();

        if (channel.equalsIgnoreCase("EMAIL")) {
            System.out.println("Connecting to SMTP Server...");
            System.out.println("Sending EMAIL to " + c.email);
            System.out.println("Dear " + c.name + ", your order " + order.getOrderId() + " is confirmed.");
            System.out.println("Total Amount (incl. tax 10%): $" + (order.calculateRawSubtotal() * 1.10));
        } else if (channel.equalsIgnoreCase("SMS")) {
            System.out.println("Connecting to SMS Gateway...");
            System.out.println("Sending SMS to " + c.phone);
            System.out.println("Order " + order.getOrderId() + " confirmed. Total: $" + (order.calculateRawSubtotal() * 1.10));
        } else if (channel.equalsIgnoreCase("PUSH")) {
            System.out.println("Connecting to Push Notification Service...");
            System.out.println("Sending Push to Customer ID: " + c.customerId);
            System.out.println("Order " + order.getOrderId() + " update!");
        } else {
            throw new IllegalArgumentException("Unsupported notification channel: " + channel);
        }
    }
}