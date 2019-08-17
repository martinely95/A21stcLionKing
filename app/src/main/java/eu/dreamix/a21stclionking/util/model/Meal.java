package eu.dreamix.a21stclionking.util.model;

public class Meal {

    public int id;
    public String name;
    public double price;

    public Meal(String meal) {
        this.id = Integer.parseInt(meal.substring(1, meal.indexOf("]")));
        this.name = meal.substring(meal.indexOf("] ") + 2, meal.indexOf(" $"));
        this.price = Double.parseDouble(meal.substring(meal.indexOf("$") + 1));
    }

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
