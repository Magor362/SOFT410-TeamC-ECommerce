import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private String status; // "PENDING", "PROCESSING", "SHIPPED", "DELIVERED"
    private int shippingZone;

    public Order(String orderId, Customer customer, int shippingZone) {
        this.orderId = orderId;
        this.customer = customer;
        this.shippingZone = shippingZone;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() { return items; }
    public Customer getCustomer() { return customer; }
    public String getOrderId() { return orderId; }
    public int getShippingZone() { return shippingZone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCustomerName() {
        return customer.name;
    }

    public String getCustomerEmail() {
        return customer.email;
    }

    public String getCustomerTier() {
        return customer.tier;
    }

    public double calculateRawSubtotal() {
        double subtotal = 0.0;
        for (OrderItem item : items) {
            subtotal += item.calculateLineTotal();
        }
        return subtotal;
    }

    public double calculateTotalWeight() {
        double totalWeight = 0.0;
        for (OrderItem item : items) {
            totalWeight += item.calculateLineWeight();
        }
        return totalWeight;
    }

    public double calculateTax() {
        return calculateRawSubtotal() * 0.10;
    }
}
