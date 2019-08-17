package eu.dreamix.a21stclionking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TablesActivity extends AppCompatActivity {

    private int[] tableIds = {
            R.id.table1,
            R.id.table2,
            R.id.table3,
            R.id.table4,
    };

    private int[] tableNamesIds = {
            R.id.tableText1,
            R.id.tableText2,
            R.id.tableText3,
            R.id.tableText4,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
    }

    public void onImageClick(View view) {
        Intent intent = new Intent(Constants.CUSTOMERS_COUNT_ACTIVITY);
        for (int i = 0; i < tableIds.length; i++) {
            if (view.getId() == tableIds[i]) {
                System.out.println(i);
                TextView tableLabel = findViewById(tableNamesIds[i]);
                intent.putExtra(Constants.TABLE_NAME_EXTRA, tableLabel.getText());
            }
        }
        startActivity(intent);
    }
}
