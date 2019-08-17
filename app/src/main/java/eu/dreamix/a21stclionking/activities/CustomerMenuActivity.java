package eu.dreamix.a21stclionking.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import eu.dreamix.a21stclionking.R;
import eu.dreamix.a21stclionking.util.Constants;
import eu.dreamix.a21stclionking.util.PreviousMargins;
import eu.dreamix.a21stclionking.util.model.Meal;
import eu.dreamix.a21stclionking.util.model.Storage;

import static eu.dreamix.a21stclionking.util.Constants.INITIAL_CUSTOMERS_COUNT;

public class CustomerMenuActivity extends AppCompatActivity {

    static final int LEFT_MARGIN = 50;
    static final int USER_NAME_VERTICAL_MARGIN = 150;
    static final int FIRST_CUSTOMER_VERTICAL_MARGIN_DECREASE = 110;
    static final int CUSTOMER_NAME_TEXT_SIZE = 30;
    static final int MENU_ITEM_TEXT_SIZE = 15;
    static final int BUTTON_TEXT_SIZE = 20;
    static final int CUSTOMER_MENU_BUTTON_WIDTH = 120;
    static final int CUSTOMER_MENU_BUTTON_HEIGHT = 120;
    static final int SMALL_MARGIN = 20;
    static final int MEDIUM_MARGIN = 50;
    static final int LARGE_MARGIN = 80;
    static final int LEFT_CUSTOMER_BUTTON_MARGIN = CUSTOMER_MENU_BUTTON_WIDTH + SMALL_MARGIN;
    private static final int BUTTON_VERTICAL_MARGIN = 120;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);
        Storage.customersCount = getIntent().getIntExtra(Constants.CUSTOMERS_COUNT_EXTRA, INITIAL_CUSTOMERS_COUNT);
        System.out.println(Storage.customersCount);
        setRelativeLayout();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setRelativeLayout() {
        setContentView(R.layout.activity_customer_menu);

        RelativeLayout layout = findViewById(R.id.mainRelativeLayout);

        layout.setBackgroundColor(Color.parseColor("#83C0B448"));

        PreviousMargins previousMargins = new PreviousMargins(-FIRST_CUSTOMER_VERTICAL_MARGIN_DECREASE, 0);

        addButtonToLayoutVertically(
                layout,
                "Tables",
                previousMargins,
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), TablesActivity.class);
                        startActivity(intent);
                    }
                });

        previousMargins.leftMargin = 0;
        addTextViewToLayout(
                layout,
                "Total: $" + calculateSubTotal(Storage.getAllMeals()),
                previousMargins,
                CUSTOMER_NAME_TEXT_SIZE
        );

        for (int customerIndex = 0; customerIndex < Storage.customersCount; customerIndex++) {
            previousMargins.leftMargin = 0;
            addEmptyCustomerToLayout(layout, "Customer " + (customerIndex + 1), previousMargins);

            List<String> meals = Storage.getMealsForCustomerId(customerIndex);
            for (int mealId = 0; mealId < meals.size(); mealId++) {
                previousMargins.leftMargin = 0;
                addMenuItemToCustomerOnLayout(layout, meals.get(mealId), previousMargins);
            }

            previousMargins.leftMargin = 0;
            addTextViewToLayout(
                    layout,
                    "Subtotal: $" + calculateSubTotal(Storage.getMealsForCustomerId(customerIndex)),
                    previousMargins,
                    BUTTON_TEXT_SIZE
            );

            // Add new customer button
            previousMargins.leftMargin = 0;
            addButtonToLayout(layout, "Add Meal", previousMargins, customerIndex);
        }

        // Add new customer button
        previousMargins.topMargin += LARGE_MARGIN;
        addButtonToLayoutVertically(layout, "Add Customer", previousMargins);
    }

    private void addEmptyCustomerToLayout(ViewGroup layout, String text, PreviousMargins previousMargins) {
        addTextViewToLayout(layout, text, previousMargins, CUSTOMER_NAME_TEXT_SIZE);

        // Add delete customer button
        addButtonToLayoutHorizontally(layout, "X", previousMargins);
    }

    private void addMenuItemToCustomerOnLayout(ViewGroup layout, String text, PreviousMargins previousMargins) {
        addTextViewToLayout(layout, text, previousMargins, MENU_ITEM_TEXT_SIZE);

        // Add copy item button
//        addButtonToLayoutHorizontally(layout, "*", previousMargins);

        addButtonToLayoutHorizontally(layout, "Y", previousMargins);

//        addButtonToLayoutHorizontally(layout, "+", previousMargins);
//
//        addButtonToLayoutHorizontally(layout, "-", previousMargins);
    }

    private double calculateSubTotal(List<String> meals) {
        double sum = 0;
        for (String meal : meals) {
            Meal mealM = new Meal(meal);
            sum += mealM.price;
        }
        return sum;
    }

    private void addTextViewToLayout(ViewGroup layout, String text, PreviousMargins previousMargins, int textSize) {
        // Create a TextView programmatically.
        TextView tv = new TextView(this);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        lp.leftMargin = LEFT_MARGIN;
        previousMargins.topMargin += USER_NAME_VERTICAL_MARGIN;
        lp.topMargin = previousMargins.topMargin;

        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);

        // Set text to display in TextView
        tv.setText(text);

        // Set a text color for TextView text
        tv.setTextColor(Color.parseColor("#000000"));

        tv.setTypeface(null, Typeface.BOLD);

        tv.setTextSize(textSize);

        tv.setLayoutParams(lp);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(tv);

        tv.measure(0, 0);
        previousMargins.leftMargin += tv.getMeasuredWidth();
    }

    private void addButtonToLayoutVertically(ViewGroup layout,
                                             String text,
                                             PreviousMargins previousMargins,
                                             View.OnClickListener onClickListener) {
        // Create a TextView programmatically.
        Button button = new Button(this);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        lp.leftMargin = LEFT_MARGIN;
        previousMargins.topMargin += BUTTON_VERTICAL_MARGIN;
        lp.topMargin = previousMargins.topMargin;

        // Apply the layout parameters to TextView widget
        button.setLayoutParams(lp);

        // Set text to display in TextView
        button.setText(text);

        // Set a text color for TextView text
        button.setTextColor(Color.parseColor("#000000"));

        button.setTypeface(null, Typeface.BOLD);

        button.setTextSize(BUTTON_TEXT_SIZE);

        button.setOnClickListener(onClickListener);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(button);
    }

    private void addButtonToLayoutVertically(ViewGroup layout, String text, PreviousMargins previousMargins) {
        // Create a TextView programmatically.
        Button button = new Button(this);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        lp.leftMargin = LEFT_MARGIN;
        previousMargins.topMargin += BUTTON_VERTICAL_MARGIN;
        lp.topMargin = previousMargins.topMargin;

        // Apply the layout parameters to TextView widget
        button.setLayoutParams(lp);

        // Set text to display in TextView
        button.setText(text);

        // Set a text color for TextView text
        button.setTextColor(Color.parseColor("#000000"));

        button.setTypeface(null, Typeface.BOLD);

        button.setTextSize(BUTTON_TEXT_SIZE);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(button);
    }

    private void addButtonToLayout(ViewGroup layout, String text, PreviousMargins previousMargins, final int customerIndex) {
        // Create a TextView programmatically.
        Button button = new Button(this);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        previousMargins.leftMargin += LEFT_CUSTOMER_BUTTON_MARGIN;
        lp.leftMargin = previousMargins.leftMargin;
        previousMargins.topMargin += BUTTON_VERTICAL_MARGIN;
        lp.topMargin = previousMargins.topMargin;

        // Apply the layout parameters to TextView widget
        button.setLayoutParams(lp);

        // Set text to display in TextView
        button.setText(text);

        // Set a text color for TextView text
        button.setTextColor(Color.parseColor("#000000"));

        button.setTypeface(null, Typeface.BOLD);

        button.setTextSize(BUTTON_TEXT_SIZE);

        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Constants.FOOD_MENU_ACTIVITY);
                Storage.clientId = customerIndex;
                startActivity(intent);
            }
        });

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(button);
    }

    private void addButtonToLayoutHorizontally(
            ViewGroup layout,
            String text,
            PreviousMargins previousMargins
    ) {
        // Create a TextView programmatically.
        Button button = new Button(this);

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                CUSTOMER_MENU_BUTTON_WIDTH, // Width of TextView
                CUSTOMER_MENU_BUTTON_HEIGHT); // Height of TextView

        previousMargins.leftMargin += LEFT_CUSTOMER_BUTTON_MARGIN;
        lp.leftMargin = previousMargins.leftMargin;
        lp.topMargin = previousMargins.topMargin;

        // Apply the layout parameters to TextView widget
        button.setLayoutParams(lp);

        // Set text to display in TextView
        button.setText(text);

        // Set a text color for TextView text
        button.setTextColor(Color.parseColor("#000000"));

        button.setTypeface(null, Typeface.BOLD);

        button.setTextSize(BUTTON_TEXT_SIZE);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(button);
    }
}
