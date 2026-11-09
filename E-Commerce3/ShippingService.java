public class ShippingService {

    public String generateShippingLabel(Order order) {
        Customer c = order.getCustomer();

        StringBuilder label = new StringBuilder();
        label.append("=== SHIPPING LABEL ===\n");
        label.append("ORDER ID: ").append(order.getOrderId()).append("\n");
        label.append("RECIPIENT: ").append(c.name).append("\n");
        label.append("ADDRESS: ").append(c.addressLine1).append("\n");
        label.append("LOCATION: ").append(c.city).append(", ")
                .append(c.state).append(" ").append(c.zipCode).append("\n");
        label.append("COUNTRY: ").append(c.country).append("\n");
        label.append("PHONE: ").append(c.phone).append("\n");
        return label.toString();
    }

    public double calculateShippingCost(Order order) {
        double totalWeight = order.calculateTotalWeight();
        int zone = order.getShippingZone();
        double baseCost = 0.0;

        if (zone == 1) {
            baseCost = (totalWeight <= 5.0) ? 5.0 : 12.0;
        } else if (zone == 2) {
            baseCost = (totalWeight <= 5.0) ? 10.0 : 25.0;
        } else {
            baseCost = 50.0 + (totalWeight * 1.5);
        }


        for (OrderItem orderItem : order.getItems()) {
            if (orderItem.getItem().getCategory().equalsIgnoreCase("FRAGILE")) {
                baseCost += 5.0; 
            }
        }

        return baseCost;
    }
}