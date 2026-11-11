import java.time.LocalDate;

public class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;
    public String addressLine1;
    public String city;
    public String state;
    public String zipCode;
    public String country;
    public int loyaltyPoints;
    public String tier; // "REGULAR", "SILVER", "GOLD", "PLATINUM"
    public LocalDate memberSince;

    public Customer(String customerId, String name, String email, String phone,
                    String addressLine1, String city, String state, String zipCode,
                    String country, String tier) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.tier = tier;
        this.loyaltyPoints = 0;
        this.memberSince = LocalDate.now();
    }
}