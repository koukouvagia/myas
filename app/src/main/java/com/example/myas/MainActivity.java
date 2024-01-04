package com.example.myas;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {

    // storage permission
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ImageView img = findViewById(R.id.menu_translate); // R.id.xxx
        System.loadLibrary("opencv"); // opencv lib
        String path = Environment.getExternalStorageDirectory().getPath() + "/saber.jpg"; // TODO: my image
        Mat mat = Imgcodecs.imread(path);
        Bitmap bmp = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.ARGB_8888);
        mat.convertTo(mat, CvType.CV_8UC3);
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGBA2BGRA);
        Utils.matToBitmap(mat, bmp);
        img.setImageBitmap(bmp);
    }

    // create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // define menu responses event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_translate:
                break;
            case R.id.menu_scale:
                break;
            case R.id.menu_mirror:
                break;
            case R.id.menu_rotate:
                break;
            default:
        }
        return true;
    }
}