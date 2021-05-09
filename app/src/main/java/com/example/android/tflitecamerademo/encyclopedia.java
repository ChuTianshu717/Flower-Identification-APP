package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.android.tflitecamerademo.pedia.pedia1;
import com.example.android.tflitecamerademo.pedia.pedia2;
import com.example.android.tflitecamerademo.pedia.pedia3;
import com.example.android.tflitecamerademo.pedia.pedia4;
import com.example.android.tflitecamerademo.pedia.pedia5;
import com.example.android.tflitecamerademo.pedia.pedia6;
import com.example.android.tflitecamerademo.pedia.pedia7;
import com.example.android.tflitecamerademo.pedia.pedia8;
import com.example.android.tflitecamerademo.pedia.pedia9;
import com.example.android.tflitecamerademo.pedia.pedia10;


public class encyclopedia extends Activity {

    private ImageButton baike1;
    private ImageButton baike2;
    private ImageButton baike3;
    private ImageButton baike4;
    private ImageButton baike5;
    private ImageButton baike6;
    private ImageButton baike7;
    private ImageButton baike8;
    private ImageButton baike9;
    private ImageButton baike10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encyclopedia_main);
        requestLocation();
    }

    private void requestLocation() {
        initView();
        setViewListener();
    }

    private void setViewListener() {
        baike1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If the album button is clicked, it goes to the image preview screen
                Intent intent = new Intent(encyclopedia.this, pedia1.class);
                startActivity(intent);
            }
        });
        baike2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia2.class);
                startActivity(intent);
            }
        });
        baike3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia3.class);
                startActivity(intent);
            }
        });
        baike4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia4.class);
                startActivity(intent);
            }
        });
        baike5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia5.class);
                startActivity(intent);
            }
        });
        baike6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia6.class);
                startActivity(intent);
            }
        });
        baike7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia7.class);
                startActivity(intent);
            }
        });
        baike8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia8.class);
                startActivity(intent);
            }
        });
        baike9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia9.class);
                startActivity(intent);
            }
        });
        baike10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果相册按钮被点击，则转向图片预览界面
                Intent intent = new Intent(encyclopedia.this, pedia10.class);
                startActivity(intent);
            }
        });
    }

    protected void initView() {
        baike1 = findViewById(R.id.baike1);
        baike2 = findViewById(R.id.baike2);
        baike3 = findViewById(R.id.baike3);
        baike4 = findViewById(R.id.baike4);
        baike5 = findViewById(R.id.baike5);
        baike6 = findViewById(R.id.baike6);
        baike7 = findViewById(R.id.baike7);
        baike8 = findViewById(R.id.baike8);
        baike9 = findViewById(R.id.baike9);
        baike10 = findViewById(R.id.baike10);
    }

}
