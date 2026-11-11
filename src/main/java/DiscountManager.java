public class DiscountManager {

    public double applyTierDiscount(Order order) {
        double subtotal = order.calculateRawSubtotal();
        String tier = order.getCustomerTier();

        double discountRate = 0.0;

        switch (tier) {
            case "REGULAR":
                if (subtotal > 500) discountRate = 0.02;
                break;
            case "SILVER":
                discountRate = 0.05;
                if (subtotal > 500) discountRate += 0.02;
                break;
            case "GOLD":
                discountRate = 0.10;
                if (subtotal > 1000) discountRate += 0.05;
                break;
            case "PLATINUM":
                discountRate = 0.20;
                break;
            default:
                discountRate = 0.0;
                break;
        }

        if (order.getItems().size() > 5) {
            discountRate += 0.03; // Bulk item discount rate
        }

        return subtotal * (1.0 - discountRate);
    }

    public double calculateInvoiceTotalWithTax(Order order) {
        double discountedSubtotal = applyTierDiscount(order);
        double taxAmount = discountedSubtotal * 0.10;
        return discountedSubtotal + taxAmount;
    }
}