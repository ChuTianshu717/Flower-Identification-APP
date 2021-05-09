package com.example.android.tflitecamerademo.pedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.android.tflitecamerademo.MainActivity;
import com.example.android.tflitecamerademo.R;
import com.example.android.tflitecamerademo.cultivation.cultivation1;
import com.example.android.tflitecamerademo.history.history1;


public class pedia1 extends Activity {

    private ImageButton history;
    private ImageButton cultivation;
    private ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedia1_main);
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
                Intent intent = new Intent(pedia1.this, history1.class);
                startActivity(intent);
            }
        });
        cultivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedia1.this, cultivation1.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pedia1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void initView() {
        history = findViewById(R.id.history1);
        cultivation = findViewById(R.id.cultivation1);
        home = findViewById(R.id.home1);
    }

}
