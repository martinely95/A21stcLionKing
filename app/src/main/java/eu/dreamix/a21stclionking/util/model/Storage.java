package eu.dreamix.a21stclionking.util.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    public static int clientId = 0;
    public static int customersCount = 1;

    private static HashMap<Integer, List<String>> customerMeals = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> getMealsForCustomerId(int customerId) {
        return customerMeals
                .getOrDefault(customerId, new ArrayList<String>());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> getAllMeals() {
        List<String> meals = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : customerMeals.entrySet()) {
            meals.addAll(entry.getValue());
        }

        return meals;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void addMealToCustomerId(int customerId, String meal) {
        List<String> meals = customerMeals.getOrDefault(customerId, new ArrayList<String>());
        meals.add(meal);
        customerMeals.put(customerId, meals);
        System.out.println(Arrays.deepToString(meals.toArray()));
    }

}
