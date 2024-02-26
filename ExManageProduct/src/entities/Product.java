package entities;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private String unit;

    public Product(int id, String name, String description, int quantity, BigDecimal price, String unit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        String formatPrice = decimalFormat.format(getPrice());
        return "id: " + id + ",\t" + "name: " + name + "\t" + ",des: " + description + "\t" + ",quantity: " + quantity + "\t" + ",price: " + formatPrice + "\t" + ",unit: " + unit;
    }
}
