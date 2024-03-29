package eu.dreamix.a21stclionking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.dreamix.a21stclionking.R;
import eu.dreamix.a21stclionking.util.Constants;
import eu.dreamix.a21stclionking.util.model.Category;
import eu.dreamix.a21stclionking.util.model.Storage;

public class FoodMenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String[] paths = {"Choose Category", "Salads", "Main Courses", "Desserts", "Drinks"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(FoodMenuActivity.this,
                android.R.layout.simple_spinner_dropdown_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Constants.CUSTOMER_MENU_ACTIVITY);
        intent.putExtra(Constants.CUSTOMERS_COUNT_EXTRA, Storage.customersCount);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Intent intent = null;

        switch (position) {
            case 0:
                break;
            case 1:
                intent = new Intent(FoodMenuActivity.this, FoodsActivity.class);
                intent.putExtra(Category.SALAD.toString(), "Salads");

                List<String> salads = new ArrayList<>(Arrays.asList(
                        "[0] Shopska salad $2.00",
                        "[1] Ovcharska salad $3.00",
                        "[2] Cesar salad $3.50"));

                intent.putStringArrayListExtra("salads", (ArrayList<String>) salads);

                break;
            case 2:
                intent = new Intent(FoodMenuActivity.this, FoodsActivity.class);
                intent.putExtra(Category.MAIN.toString(), "Main Courses");

                List<String> mains = new ArrayList<>(Arrays.asList(
                        "[0] Creamy courgette lasagne $8.50",
                        "[1] Salmon $12.00",
                        "[2] Chicken pie $10.00"));

                intent.putStringArrayListExtra("mains", (ArrayList<String>) mains);

                break;
            case 3:
                intent = new Intent(FoodMenuActivity.this, FoodsActivity.class);
                intent.putExtra(Category.DESSERT.toString(), "Desserts");

                List<String> desserts = new ArrayList<>(Arrays.asList(
                        "[0] Peanut Butter Cup Brownies $3.00",
                        "[1] Coconut Macaroons $3.50",
                        "[2] Chewy Spice Cookies $2.00"));

                intent.putStringArrayListExtra("desserts", (ArrayList<String>) desserts);

                break;
            default:
                intent = new Intent(FoodMenuActivity.this, FoodsActivity.class);
                intent.putExtra(Category.DRINK.toString(), "Drinks");

                List<String> drinks = new ArrayList<>(Arrays.asList(
                        "[0] Water 500ml $1.50",
                        "[1] Beer 500ml $3.00",
                        "[2] Wine 250ml $6.00"));

                intent.putStringArrayListExtra("drinks", (ArrayList<String>) drinks);
                break;
        }
        if (intent != null) startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

}
