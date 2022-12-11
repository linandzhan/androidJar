package com.zwk.testndkdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zwk.myframe.activity.BaseSkinActivity;
import com.zwk.myframe.ioc.OnClick;
import com.zwk.myframe.permission.PermissionHelper;
import com.zwk.myframe.selectimage.ImageSelectActivity;
import com.zwk.myframe.selectimage.ImageSelector;
import com.zwk.myframe.selectimage.bean.ImageEntity;


import java.util.ArrayList;

public class MainActivity extends BaseSkinActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void initData() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_WRITE_STORE);
//        }
        PermissionHelper.requestPermission(this,0,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }
    @OnClick(R.id.test_image_selector)
    public void testImageSelector(View view) {
        Toast.makeText(this,"testImage",Toast.LENGTH_SHORT).show();
        ImageSelector.create().start(this,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            ArrayList<ImageEntity> imageEntities = data.getParcelableArrayListExtra(ImageSelector.EXTRA_RESULT);
            ImageEntity imageEntity = imageEntities.get(0);
            Log.i(TAG, "onActivityResult: " + imageEntity);
//            for (ImageEntity imageEntity : imageEntities) {
//                Log.i(TAG, "onActivityResult: " + imageEntity);
//            }
        }
    }
}