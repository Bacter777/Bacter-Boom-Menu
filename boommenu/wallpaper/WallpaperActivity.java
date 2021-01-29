package com.bacter.boommenu.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import com.bacter.boommenu.R;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class WallpaperActivity extends AppCompatActivity
{
    List<customItems> itemsList;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ProgressBar progressBar;
    Context context;
    ShimmerFrameLayout activity_wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        this.activity_wallpaper = findViewById(R.id.activity_wallpaper);
        this.activity_wallpaper.useDefaults();
        this.activity_wallpaper.startShimmerAnimation();
        this.context = this;
        this.recyclerView = findViewById(R.id.recyclerView);
        this.recyclerView.setHasFixedSize(true);
        this.progressBar = findViewById(R.id.progreeBar);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        this.itemsList = new ArrayList<>();
        this.itemsList.add(new customItems("CPC","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/cpc.png"));
        this.itemsList.add(new customItems("Tau Gamma Sigma","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/TauGammaSigmaII.png"));
        this.itemsList.add(new customItems("Tau Gamma Sigma","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/TauGammaSigmaIII.png"));
        this.itemsList.add(new customItems("Tau Gamma Sigma","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/TauGammaSigmaIV.png"));
        this.itemsList.add(new customItems("Urgello Chapter","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/UrgelloChapter.png"));
        this.itemsList.add(new customItems("Urgello Chapter Since 1993","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/UrgelloChapterSince1993.png"));
        this.itemsList.add(new customItems("We Are Strong","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/WeAreStrong.png"));
        this.itemsList.add(new customItems("We Are Strong 2","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/WeAreStrongII.png"));
        this.itemsList.add(new customItems("Tau Gamma Sigma","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/TauGammaSigmaV.png"));
        this.itemsList.add(new customItems("Greek","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/Greek.png"));
        this.itemsList.add(new customItems("Greek Letters","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/Greek_Letters.png"));
        this.itemsList.add(new customItems("Triskelion Blue Logo","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/blue.png"));
        this.itemsList.add(new customItems("True Blooded Triskelion","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/true_blooded.png"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/Transkelion.png"));
        this.itemsList.add(new customItems("Sigmalupet","https://raw.githubusercontent.com/Bacter777/TauGammaSigma-Wallpapers/master/Sigmalupet.png"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/wallpapers/master/8fd647cb20745e208110fc3bff159609.jpg"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/wallpapers/master/8ea075044b03654b16c38f07539d371d.jpg"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/wallpapers/master/73c0897c244373216c18c58134400ab1.jpg"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/wallpapers/master/60ee5717fe69bfec5da8cbed8a18a3be.jpg"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/wallpapers/master/4b07914ebd65b43ccac825523d5d4829.jpg"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/tgp.png"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/db27568e75de7439dcb4bd97ba61e632.png"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Triskelion_Logo_3.png"));
        this.itemsList.add(new customItems("Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Triskelion.png"));
        this.itemsList.add(new customItems("Lady Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Triskelion%20Ladies.png"));
        this.itemsList.add(new customItems("Tau Gamma Phi","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/T_G_P.png\""));
        this.itemsList.add(new customItems("Golden Anniversary","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/TGP_Golden_Anniversary.png"));
        this.itemsList.add(new customItems("Sigmalakas","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Sigmalakas.png"));
        this.itemsList.add(new customItems("Lady Triskelion","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/LadyTriskelion.png"));
        this.itemsList.add(new customItems("John Mark Designs","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/John_Mark_Designs.png"));
        this.itemsList.add(new customItems("Brave & Humble","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Brave_Humble_Triskelion.png"));
        this.itemsList.add(new customItems("We Are Born Equal","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Born_Equal.png"));
        this.itemsList.add(new customItems("44th Anniversary","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/44th_Founding.png"));
        this.itemsList.add(new customItems("Black Logo","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Black.png"));
        this.itemsList.add(new customItems("Blurred","https://raw.githubusercontent.com/Bacter777/TGP-Wallpaper/master/Blurred.png"));

        this.activity_wallpaper.stopShimmerAnimation();
        RecyclerViewAdapter recyclerViewAdapter2 = new RecyclerViewAdapter(this,itemsList,this);
        this.adapter = recyclerViewAdapter2;
        this.recyclerView.setAdapter(recyclerViewAdapter2);

    }
}