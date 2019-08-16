package eu.dreamix.a21stclionking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomersCountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_count);
    }

    public void onOkClick(View view) {
        Intent intent = new Intent(".CustomerMenuActivity");
        startActivity(intent);
    }

    public void onIncreaseClick(View view) {
        TextView textView = findViewById(R.id.customerCount);
        int customersCount = Integer.parseInt(textView.getText().toString());
        textView.setText(String.valueOf(++customersCount));
    }

    public void onDecreaseClick(View view) {
        TextView textView = findViewById(R.id.customerCount);
        int customersCount = Integer.parseInt(textView.getText().toString());
        textView.setText(String.valueOf(--customersCount > 1 ? customersCount : 1));
    }

}
