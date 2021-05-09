package com.example.android.tflitecamerademo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    /**
     * Some statements about the layout
     */
    private Button mCamera;
    private Button mAlbum;
    private ImageButton mbaike;


    public static int flag;
    public static final int camera = 1;
    public static final int album = 2;

    private static final int CROP_PHOTO = 2;
    private static final int REQUEST_CODE_PICK_IMAGE = 3;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 6;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 7;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    /**
     * Initialize the price control event
     */
    private void initEvent() {

        //Set listening for the photo button
        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If the photo button is clicked, it goes to the photo screen
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        //Set listening for the album button
        mbaike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = album;
                //If the album button is clicked, it goes to the image preview screen
                Intent intent = new Intent(MainActivity.this, encyclopedia.class);
                startActivity(intent);
            }
        });
        mAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhone(v);
            }
        });
    }

    public void choosePhone(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_CALL_PHONE2);
        else
            choosePhoto();
    }

    void choosePhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//Photo type
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    public void onActivityResult(int req, int res, Intent data) {
        switch (req) {
            /**
             * Request sign to take photos
             */
            case CROP_PHOTO:
                if (res == RESULT_OK) {
                    try {
                        /**
                         * This URI is the URI for the photos folder
                         */
                        Intent intent = new Intent(MainActivity.this, ChoosePhoto.class);
                        intent.setData(imageUri);
                        startActivity(intent);


                    } catch (Exception e) {
                        Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Log.i("tag", "失败");
                break;
            /**
             * Request flag to select an image from an album
             */
            case REQUEST_CODE_PICK_IMAGE:
                if (res == RESULT_OK) {
                    try {
                        /**
                         * This URI is returned by the previous Activity
                         */
                        Uri uri = data.getData();
                        Intent intent = new Intent(MainActivity.this, ChoosePhoto.class);
                        intent.setData(uri);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d("tag", e.getMessage());
                        Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Log.i("liang", "失败");
                break;

            default:
                break;
        }
    }
    /**
     * Initialize the layout
     */
    private void initView() {

        //绑定控件
        mCamera = (Button) this.findViewById(R.id.camera_btn);
        mAlbum = (Button) this.findViewById(R.id.album_btn);
        mbaike = findViewById(R.id.baike_btn);
    }
}
