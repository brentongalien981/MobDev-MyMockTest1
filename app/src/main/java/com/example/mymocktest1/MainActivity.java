package com.example.mymocktest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView chartImageView;
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set bitmap.
        int width = (int) getResources().getDimension(R.dimen.chart_image_view_width);
        int height = (int) getResources().getDimension(R.dimen.chart_image_view_height);
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        // Set the canvas.
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLACK);

        // Set the imageview.
        chartImageView = (ImageView) findViewById(R.id.chartImageView);
        chartImageView.setImageBitmap(bitmap);
//        chartImageView.draw(canvas);

        // Set the paint.
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);


        paintRectangles();
        paintTexts();
        // TODO: Draw circles.
        // TODO: Draw paths.

//        chartImageView.invalidate();


        // Add event-handler to the-button.
        Button theBtn = (Button) findViewById(R.id.theBtn);
        theBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int[] passedIntArr = {1, 2, 3};
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("passedIntArr", passedIntArr);

                startActivity(intent);

            }
        });
    }


    private void paintTexts() {

        paint.setTextSize(100);
        paint.setColor(Color.RED);
        canvas.drawText("!X", 10, 100, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawText("O", 100, 100, paint);

        paint.setColor(Color.BLUE);
        canvas.drawText("B", 200, 100, paint);

    }


    private void paintRectangles() {

        int gap = 10;
        int horBarHeight = 50;
        int nextBarTop = 10;
        int nextBarBottom = nextBarTop + horBarHeight;

        /* Draw rectangles */
        // Horizontal bars.
        // left, top, right, bottom
        paint.setColor(Color.WHITE);
        canvas.drawRect(10, nextBarTop, 500, nextBarBottom, paint);

        nextBarTop += horBarHeight + gap;
        nextBarBottom = nextBarTop + horBarHeight;
        paint.setColor(Color.YELLOW);
        canvas.drawRect(10, nextBarTop, 300, nextBarBottom, paint);

        nextBarTop += horBarHeight + gap;
        nextBarBottom = nextBarTop + horBarHeight;
        paint.setColor(Color.RED);
        canvas.drawRect(10, nextBarTop, 450, nextBarBottom, paint);


        // Paint vertical bars.
        paint.setColor(Color.GREEN);
        canvas.drawRect(10, 300, 60, 790, paint);

        paint.setColor(Color.rgb(245, 173, 66));
        canvas.drawRect(70, 400, 120, 790, paint);


        // Paint vertical bars based on percentages.
        int percentages[] = {100, 50, 38, 12, 67, 85, 3, 32, 79};
        paintBarsByPercentages(percentages);

    }

    private void paintBarsByPercentages(int[] percentages) {

        int startLeft = 130;
        int barWidth = 30;
        int gap = 10;
        int bottom = 790;
        int maxHeight = 600;

        for (int i = 0; i < percentages.length; i++) {

            int left = startLeft + (i * barWidth) + (i * gap);
            int top = bottom - (maxHeight * percentages[i] / 100);
            int right = left + barWidth;

            paint.setColor(Color.GREEN);
            canvas.drawRect(left, top, right, bottom, paint);

        }
    }
}