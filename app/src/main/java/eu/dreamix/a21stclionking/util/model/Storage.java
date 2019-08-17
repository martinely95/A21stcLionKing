package eu.dreamix.a21stclionking.util.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Storage {

    public static int clientId = 0;

    private static HashMap<Integer, List<String>> customerMeals = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> getMealsForCustomerId(int customerId) {
        return customerMeals
                .getOrDefault(customerId, new ArrayList<String>());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void addMealToCustomerId(int customerId, String meal) {
        List<String> meals = customerMeals.getOrDefault(customerId, new ArrayList<String>());
        meals.add(meal);
        customerMeals.put(customerId, meals);
        System.out.println(Arrays.deepToString(meals.toArray()));
    }

}
