package eu.dreamix.a21stclionking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import static eu.dreamix.a21stclionking.Constants.INITIAL_CUSTOMERS_COUNT;

public class CustomerMenuActivity extends AppCompatActivity {

    private int customersCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu);
        System.out.println(getIntent().getIntExtra("customersCount", INITIAL_CUSTOMERS_COUNT));

    }
}
