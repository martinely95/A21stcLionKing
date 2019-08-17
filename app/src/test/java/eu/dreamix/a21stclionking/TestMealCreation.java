package eu.dreamix.a21stclionking;

import org.junit.Test;

import eu.dreamix.a21stclionking.util.model.Meal;

import static org.junit.Assert.assertEquals;

public class TestMealCreation {

    @Test
    public void testMealCreationFromStringSalad() {
        Meal meal = new Meal("[0] Shopska salad $2.00");

        assertEquals(0, meal.id);
        assertEquals("Shopska salad", meal.name);
        assertEquals(2.0, meal.price, 0.1);
    }

    @Test
    public void testMealCreationFromStringMain() {
        Meal meal = new Meal("[1] Salmon $12.00");

        assertEquals(1, meal.id);
        assertEquals("Salmon", meal.name);
        assertEquals(12.0, meal.price, 0.1);
    }

    @Test
    public void testMealCreationFromStringDessert() {
        Meal meal = new Meal("[2] Chewy Spice Cookies $2.00");

        assertEquals(2, meal.id);
        assertEquals("Chewy Spice Cookies", meal.name);
        assertEquals(2.0, meal.price, 0.1);
    }

    @Test
    public void testMealCreationFromStringDrink() {
        Meal meal = new Meal("[1] Beer 500ml $3.00");

        assertEquals(1, meal.id);
        assertEquals("Beer 500ml", meal.name);
        assertEquals(3.0, meal.price, 0.1);
    }

}
