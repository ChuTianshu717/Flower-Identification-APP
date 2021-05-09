package com.example.android.tflitecamerademo.pedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.android.tflitecamerademo.MainActivity;
import com.example.android.tflitecamerademo.R;
import com.example.android.tflitecamerademo.cultivation.cultivation8;
import com.example.android.tflitecamerademo.history.history8;


public class pedia8 extends Activity {

    private ImageButton history;
    private ImageButton cultivation;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedia8_main);
        requestLocation();
    }

    private void requestLocation() {
        initView();
        setViewListener();
    }

    private void setViewListener() {
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedia8.this, history8.class);
                startActivity(intent);
            }
        });
        cultivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedia8.this, cultivation8.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedia8.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void initView() {
        history = findViewById(R.id.history8);
        cultivation = findViewById(R.id.cultivation8);
        home = findViewById(R.id.home8);
    }

}
