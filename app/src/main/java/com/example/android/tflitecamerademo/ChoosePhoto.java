package com.example.android.tflitecamerademo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.tflitecamerademo.album.Comfirm;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChoosePhoto extends AppCompatActivity {
    private ImageView imageView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_photo);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        initView();

        Uri uri = getIntent().getData();
        Bitmap bit = null;
        try {
            bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("tag", e.getMessage());
            Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();
        }
        imageView.setImageBitmap(bit);
    }

    void initView() {
        imageView = (ImageView) findViewById(R.id.image);
        mButton = (Button) findViewById(R.id.button_discern);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.buildDrawingCache(true);
                imageView.buildDrawingCache();
                Bitmap bitmap = imageView.getDrawingCache();
                String tmp_path = saveBitmapFile(bitmap);

                imageView.setDrawingCacheEnabled(false);
                imageView.setDrawingCacheEnabled(false);

                Comfirm comf = new Comfirm(tmp_path);

                String tmp_comf = comf.Search();

                Toast.makeText(ChoosePhoto.this, tmp_comf, Toast.LENGTH_LONG).show();

                if (!tmp_comf.equals("非植物")) {

                    Intent i = new Intent(ChoosePhoto.this, ViewActivity.class);
                    i.putExtra("data", tmp_comf);
                    startActivity(i);
                } else {

                    Intent i = new Intent(ChoosePhoto.this, ViewActivity.class);
//                    Toast.makeText(ChoosePhoto.this, "This object is not a plant", Toast.LENGTH_LONG).show();
                    i.putExtra("data", "It is not a flower");
                    startActivity(i);
                }
            }

        });
    }

    public String saveBitmapFile(Bitmap bitmap) {

        File temp = new File("/sdcard/flower-comf/");//To save the file, create a folder
        if (!temp.exists()) {
            temp.mkdir();
        }
        ////When saving repeatedly, overwrite the original picture with the same name
        String name = System.currentTimeMillis() + ".jpg";
        String path = "/sdcard/flower-comf/" + name;


        File file = new File(path);//The path and name of the image to be saved
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
