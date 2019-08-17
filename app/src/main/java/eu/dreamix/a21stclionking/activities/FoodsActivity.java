package eu.dreamix.a21stclionking.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import eu.dreamix.a21stclionking.R;
import eu.dreamix.a21stclionking.util.model.Storage;

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

        System.out.println(Storage.clientId);

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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long itemId) {
                TextView textView = (TextView) view;
                Storage.addMealToCustomerId(Storage.clientId, textView.getText().toString());
                finish();
            }
        });
    }

    public void setListView(String category) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_food, R.id.food,
                intent.getStringArrayListExtra(category));

//            @Override
//            public View getView(int position, View convertView, ViewGroup parent){
//
//                View view = super.getView(position, convertView, parent);
//
////                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
////                layoutParams.height = 50;
//
////                TextView tv = view.findViewById(R.id.food);
////
////                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
//
//                return view;
//            }
//        };

        listView.setAdapter(adapter);

    }
}
