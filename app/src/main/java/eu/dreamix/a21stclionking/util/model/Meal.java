package eu.dreamix.a21stclionking.util.model;

public class Meal {

    public int id;
    public String name;
    public double price;

    public Meal(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + id + "] "
                + name
                + " $ " + price;
    }
}
