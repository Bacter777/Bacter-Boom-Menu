package com.bacter.boommenu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bacter.boommenu.R;
import com.bacter.boommenu.helper.BacterHelper;

public class AboutActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        BacterHelper.with(this).loadAbout();
    }
}