package eu.dreamix.a21stclionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TablesActivity extends AppCompatActivity {

    private int[] tableIds = {
            R.id.table1,
            R.id.table2,
            R.id.table3,
            R.id.table4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
    }

    public void onImageClick(View view) {
        Intent intent = new Intent(".CustomersCountActivity");
        for (int i = 0; i < tableIds.length; i++) {
            if (view.getId() == tableIds[i]) {
                System.out.println(i);
                intent.putExtra("tableName", "Table " + (i + 1));
            }
        }
        startActivity(intent);
    }
}
