package com.trycatchkamal.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.R;

public class DemoActivity extends AppCompatActivity {
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private PolygonLayout layout;
    private int padding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        padding = getResources().getDimensionPixelOffset(R.dimen.event_icon_padding);
        imageButton1 = new ImageButton(this);
        imageButton2 = new ImageButton(this);
        imageButton3 = new ImageButton(this);
        imageButton4 = new ImageButton(this);
        imageButton5 = new ImageButton(this);

        imageButton1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        imageButton1.setImageResource(R.drawable.cart);
        imageButton1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton1.setAdjustViewBounds(true);
        imageButton1.setPadding(padding, padding, padding, padding);

        imageButton2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        imageButton2.setImageResource(R.drawable.more);
        imageButton2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton2.setAdjustViewBounds(true);
        imageButton2.setPadding(padding, padding, padding, padding);

        imageButton3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        imageButton3.setImageResource(R.drawable.info);
        imageButton3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton3.setAdjustViewBounds(true);
        imageButton3.setPadding(padding, padding, padding, padding);

        imageButton4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        imageButton4.setImageResource(R.drawable.less);
        imageButton4.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton4.setAdjustViewBounds(true);
        imageButton4.setPadding(padding, padding, padding, padding);

        imageButton5.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        imageButton5.setImageResource(R.drawable.username);
        imageButton5.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton5.setAdjustViewBounds(true);
        imageButton5.setPadding(padding, padding, padding, padding);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked cart", Toast.LENGTH_SHORT).show();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked info", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked less", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked more", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "clicked username", Toast.LENGTH_SHORT).show();
            }
        });
        layout = new PolygonLayout(this);
    }

    public void onclick(View view) {
        layout.removeAllViews();
        switch (view.getId()) {
            case R.id.btnVG2:
                layout.addView(imageButton1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
            case R.id.btnVG3:
                layout.addView(imageButton1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton3, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
            case R.id.btnVG4:

                layout.addView(imageButton1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton3, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton4, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
            case R.id.btnVG5:
                layout.addView(imageButton1, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton2, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton3, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton4, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layout.addView(imageButton5, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                break;
        }
        setContentView(layout);
    }
}
