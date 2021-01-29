package com.bacter.boommenu.wallpaper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bacter.boommenu.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import cc.shinichi.wallpaperlib.SetWallpaper;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final int PERMISSION_REQUEST_CODE=1000;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton btnSet;
    FloatingActionButton btnDownload;
    ImageView imageView;

    public void onRequestPermissionResult(int requestCode,String[]permissions,int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode !=1000){
            return;
        }
        if (grantResults.length<=0 || grantResults[0]!=0){
            Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        if (ActivityCompat.checkSelfPermission(this,"android.permission.WRITE_EXTERNAL_STORAGE")!=0 && Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},PERMISSION_REQUEST_CODE);
        }

        this.floatingActionMenu = findViewById(R.id.floatingActionMenu);
        this.btnSet = findViewById(R.id.setWallpaper);
        this.btnDownload = findViewById(R.id.downloadWallpaper);
        this.imageView = findViewById(R.id.fullImage);
        Picasso.get().load(getIntent().getStringExtra("images")).into(this.imageView);
        this.btnDownload.setOnClickListener(this);
        this.btnSet.setOnClickListener(this);


    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.setWallpaper:
         //       setAsWall();
                floatingActionMenu.close(true);
                return;
            case R.id.downloadWallpaper:
                saveImage();
                floatingActionMenu.close(true);
        }
    }
    private void saveImage(){
        if (ActivityCompat.checkSelfPermission(this,"android.permission.WRITE_EXTERNAL_STORAGE")!=0){
            Toast.makeText(this,"You Should Grant This Permission You IDIOT!",Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT>=23){
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},PERMISSION_REQUEST_CODE);
                return;
            }
            return;
        }
        RequestCreator load = Picasso.get().load(getIntent().getStringExtra("images"));
        Context baseContext = getBaseContext();
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        load.into(new SaveImageHelper(baseContext,contentResolver, UUID.randomUUID().toString()+"jpg","Image Description"));
    }
}