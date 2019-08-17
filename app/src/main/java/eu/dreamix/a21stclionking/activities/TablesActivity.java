package eu.dreamix.a21stclionking.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import eu.dreamix.a21stclionking.util.Constants;
import eu.dreamix.a21stclionking.R;

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

    @NonNull
    static private Bitmap getBitmapFromDrawable(@NonNull Drawable drawable) {
        final Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bmp;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        for (int tableId : tableIds) {
            roundImage((ImageView) findViewById(tableId));
        }
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void roundImage(ImageView imageView) {
        Bitmap mbitmap = getBitmapFromDrawable(getDrawable(R.mipmap.ic_launcher_foreground));
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint);// Round Image Corner 100 100 100 100
        imageView.setImageBitmap(imageRounded);
    }

}
