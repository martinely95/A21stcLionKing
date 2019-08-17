package eu.dreamix.a21stclionking.util.model;

public enum Category {
    SALAD("salad"), MAIN("main"), DESSERT("dessert"), DRINK("drink");

    private String value;

    Category(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
