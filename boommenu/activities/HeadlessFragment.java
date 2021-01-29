package com.bacter.boommenu.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bacter.boommenu.R;
import com.bacter.boommenu.helper.BacterHelper;

public class HeadlessFragment extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(new LinearLayout(this));

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(android.R.id.content, new BacterHeadlessFragment())
                .commit();
    }
    public static class BacterHeadlessFragment extends Fragment
    {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState)
        {
            return inflater.inflate(R.layout.activity_about,container,false);
        }
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            setRetainInstance(true);
            BacterHelper.with(getActivity()).loadAbout();
        }
    }
}
