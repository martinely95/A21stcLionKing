package eu.dreamix.a21stclionking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
    }

    public void onClickImageListener(View view) {
        Intent intent = new Intent(".CustomersCountActivity");
        startActivity(intent);
    }
}
