package eu.dreamix.a21stclionking.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import eu.dreamix.a21stclionking.R;

public class FoodsActivity extends AppCompatActivity {

    private Intent intent = getIntent();
    private TextView textView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        intent = getIntent();
        textView = findViewById(R.id.categoryTitle);

        listView = findViewById(R.id.listOfFoods);


        if (intent.getStringExtra("salad") != null) {
            textView.setText("SALADS");

            setListView("salads");

        } else if (intent.getStringExtra("main") != null) {
            textView.setText("MAIN");

            setListView("mains");
        } else if (intent.getStringExtra("dessert") != null) {
            textView.setText("DESSERTS");

            setListView("desserts");
        } else {
            textView.setText("DRINKS");

            setListView("drinks");
        }
    }

    public void setListView(String category) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_foods, R.id.categoryTitle,
                intent.getStringArrayListExtra(category)) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                TextView tv = view.findViewById(R.id.categoryTitle);

                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);

                return view;
            }
        };

        listView.setAdapter(adapter);
    }
}
