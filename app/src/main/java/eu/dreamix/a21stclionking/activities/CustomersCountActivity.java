package eu.dreamix.a21stclionking.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import eu.dreamix.a21stclionking.util.Constants;
import eu.dreamix.a21stclionking.R;

import static eu.dreamix.a21stclionking.util.Constants.INITIAL_CUSTOMERS_COUNT;

public class CustomersCountActivity extends AppCompatActivity {

    private int customersCount = INITIAL_CUSTOMERS_COUNT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_count);

        TextView textView = findViewById(R.id.customerCount);
        textView.setText(String.valueOf(customersCount));

        TextView tableName = findViewById(R.id.tableName);
        tableName.setText(getIntent().getStringExtra(Constants.TABLE_NAME_EXTRA));
    }

    public void onOkClick(View view) {
        Intent intent = new Intent(Constants.CUSTOMER_MENU_ACTIVITY);
        intent.putExtra(Constants.CUSTOMERS_COUNT_EXTRA, customersCount);
        startActivity(intent);
    }

    public void onIncreaseClick(View view) {
        TextView textView = findViewById(R.id.customerCount);
        customersCount = Integer.parseInt(textView.getText().toString());
        textView.setText(String.valueOf(++customersCount));
    }

    public void onDecreaseClick(View view) {
        TextView textView = findViewById(R.id.customerCount);
        customersCount = Integer.parseInt(textView.getText().toString());
        textView.setText(
                String.valueOf(
                        --customersCount > INITIAL_CUSTOMERS_COUNT ? customersCount : INITIAL_CUSTOMERS_COUNT
                )
        );
    }

}
