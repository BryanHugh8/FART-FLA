package models;

public class Artwork {
    private String name;
    private double price;
    private String category;

    public Artwork(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Type: %s | Price: Rp. %,d", name, category, (long) price);
    }
}
