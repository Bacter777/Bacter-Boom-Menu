package com.bacter.boommenu.youtubeless;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.bacter.boommenu.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class YouTubePlayerFragmentActivity extends YouTubeBaseActivity
{
    public static final String API_KEY = "AIzaSyBx7v0YOb140fDO7EbfMx4l87raxezDWFw";
    public static final String VIDEO_ID = "DQEO8IQAv14";

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player_fragment);

        // initializing and adding YoutubePlayerFragment
        FragmentManager fm = getFragmentManager();
        String tag = YouTubePlayerFragment.class.getSimpleName();
        YouTubePlayerFragment playerFragment = (YouTubePlayerFragment)fm.findFragmentByTag(tag);
        if (playerFragment == null)
        {
            FragmentTransaction ft = fm.beginTransaction();
            playerFragment = YouTubePlayerFragment.newInstance();
            ft.add(android.R.id.content, playerFragment,tag);
            ft.commit();
        }
        playerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(VIDEO_ID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(YouTubePlayerFragmentActivity.this,"Oopsss... Error While Initializing YoutubePlayer!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
