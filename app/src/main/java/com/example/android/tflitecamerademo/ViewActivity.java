package com.example.android.tflitecamerademo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.android.tflitecamerademo.pedia.pedia1;
import com.example.android.tflitecamerademo.pedia.pedia10;
import com.example.android.tflitecamerademo.pedia.pedia2;
import com.example.android.tflitecamerademo.pedia.pedia3;
import com.example.android.tflitecamerademo.pedia.pedia4;
import com.example.android.tflitecamerademo.pedia.pedia5;
import com.example.android.tflitecamerademo.pedia.pedia6;
import com.example.android.tflitecamerademo.pedia.pedia7;
import com.example.android.tflitecamerademo.pedia.pedia8;
import com.example.android.tflitecamerademo.pedia.pedia9;

public class ViewActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        init();
    }

    private void init() {
        TextView textView = (TextView) findViewById(R.id.text);
        String result = getIntent().getStringExtra("data");
        textView.setText(result);
        if (result.equals("荷花")) {
            Intent intent = new Intent(ViewActivity.this, pedia1.class);
            startActivity(intent);
        }
        if (result.equals("菊花")) {
            Intent intent = new Intent(ViewActivity.this, pedia2.class);
            startActivity(intent);
        }
        if (result.equals("玫瑰")) {
            Intent intent = new Intent(ViewActivity.this, pedia3.class);
            startActivity(intent);
        }
        if (result.equals("牡丹")) {
            Intent intent = new Intent(ViewActivity.this, pedia4.class);
            startActivity(intent);
        }
        if (result.equals("蒲公英")) {
            Intent intent = new Intent(ViewActivity.this, pedia5.class);
            startActivity(intent);
        }
        if (result.equals("牵牛花")) {
            Intent intent = new Intent(ViewActivity.this, pedia6.class);
            startActivity(intent);
        }
        if (result.equals("水仙花")) {
            Intent intent = new Intent(ViewActivity.this, pedia7.class);
            startActivity(intent);
        }
        if (result.equals("向日葵")) {
            Intent intent = new Intent(ViewActivity.this, pedia8.class);
            startActivity(intent);
        }
        if (result.equals("樱花")) {
            Intent intent = new Intent(ViewActivity.this, pedia9.class);
            startActivity(intent);
        }
        if (result.equals("郁金香")) {
            Intent intent = new Intent(ViewActivity.this, pedia10.class);
            startActivity(intent);
        }
    }
}
