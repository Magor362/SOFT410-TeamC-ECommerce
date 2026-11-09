public class Item {
    private String itemCode;
    private String name;
    private double price;
    private double weightKg;
    private String category; // "ELECTRONICS", "BOOKS", "CLOTHING", "FRAGILE"

    public Item(String itemCode, String name, double price, double weightKg, String category) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.weightKg = weightKg;
        this.category = category;
    }

    public String getItemCode() { return itemCode; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getWeightKg() { return weightKg; }
    public String getCategory() { return category; }
}
