package eu.dreamix.a21stclionking;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static eu.dreamix.a21stclionking.Constants.INITIAL_CUSTOMERS_COUNT;

public class CustomerMenuActivity extends AppCompatActivity {

    static final int LEFT_MARGIN = 50;
    static final int USER_NAME_VERTICAL_MARGIN = 150;
    static final int FIRST_CUSTOMER_VERTICAL_MARGIN_DECREASE = 110;
    static final int SIZE = 30;
    private static final int BUTTON_VERTICAL_MARGIN = 120;
    private int customersCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);
        customersCount = getIntent().getIntExtra(Constants.CUSTOMERS_COUNT_EXTRA, INITIAL_CUSTOMERS_COUNT);
        System.out.println(customersCount);
        setRelativeLayout();
    }

    private void setRelativeLayout() {
        setContentView(R.layout.activity_customer_menu);

        RelativeLayout layout = new RelativeLayout(this);
        setContentView(layout);

        layout.setBackgroundColor(Color.parseColor("#83C0B448"));

        PreviousMargins previousMargins = new PreviousMargins(-FIRST_CUSTOMER_VERTICAL_MARGIN_DECREASE, 0);

        for (int customerIndex = 0; customerIndex < customersCount; customerIndex++) {
            addTextViewToLayout(layout, "Customer" + (customerIndex + 1), previousMargins);
        }
    }

    private void addTextViewToLayout(ViewGroup layout, String text, PreviousMargins previousMargins) {
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

        tv.setTextSize(SIZE);

        tv.setLayoutParams(lp);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(tv);

        addButtonToLayoutVertically(layout, "+", previousMargins);
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

        button.setTextSize(SIZE);

        // Add newly created TextView to parent view group (RelativeLayout)
        layout.addView(button);
    }
}
