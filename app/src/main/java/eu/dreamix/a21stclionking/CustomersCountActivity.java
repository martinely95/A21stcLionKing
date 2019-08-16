package eu.dreamix.a21stclionking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomersCountActivity extends AppCompatActivity {

    private static int customersCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_count);

        TextView textView = findViewById(R.id.customerCount);
        textView.setText(String.valueOf(customersCount));
    }

    public void onOkClick(View view) {
        Intent intent = new Intent(".CustomerMenuActivity");
        intent.putExtra("customerCount", customersCount);
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
        textView.setText(String.valueOf(--customersCount > 1 ? customersCount : 1));
    }

}
