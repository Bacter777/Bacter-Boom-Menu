package com.bacter.boommenu.youtubeless;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bacter.boommenu.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

@SuppressWarnings("deprecation")
public class HymnActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,View.OnClickListener
{
    private static final String TAG = HymnActivity.class.getSimpleName();
    //MY YOUTUBE API KEY
    public static final String API_KEY = "AIzaSyA2ySbql3Lnp57iTqRFQqMfhzVWfh0KQP8";
    public static final String VIDEO_ID = "DQEO8IQAv14";//https://www.youtube.com/watch?v=<VIDEO_ID>
    private YouTubePlayer mPlayer;
    private View mPlayButtonLayout;
    private TextView mPlayTimeTextView;
    private Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymn);
        manageBlinkEffect();

        // INITIALIZING YOUTUBE PLAYER VIEW
        YouTubePlayerView youTubePlayerView =  findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);
        //ADDING PLAY BUTTON EXPLICITLY PLAY VIDEO IN YOUTUBE PLAYER VIEW
        mPlayButtonLayout = findViewById(R.id.video_control);
        findViewById(R.id.play_video).setOnClickListener(this);
        findViewById(R.id.pause_video).setOnClickListener(this);
        mPlayTimeTextView =  findViewById(R.id.play_time);
        SeekBar mSeekBar = findViewById(R.id.video_seeker);
        mSeekBar.setOnSeekBarChangeListener(mVideoSeekBarChangeListener);
        mHandler = new Handler();
    }
    private void manageBlinkEffect()
    {
        final TextView dev = findViewById(R.id.dev);
        ObjectAnimator anim = ObjectAnimator.ofInt(dev,"textColor",
                Color.RED,Color.WHITE,Color.BLUE);
        anim.setDuration(1500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_video:
                if (null != mPlayer && !mPlayer.isPlaying())
                    mPlayer.play();
                break;
            case R.id.pause_video:
                if (null != mPlayer && mPlayer.isPlaying())
                    mPlayer.pause();
                break;
        }
    }
    private void displayCurrentTime() {
        if (null == mPlayer) return;
        String formattedTime = formatTime(mPlayer.getDurationMillis() - mPlayer.getCurrentTimeMillis());
        mPlayTimeTextView.setText(formattedTime);
    }
    @SuppressLint("DefaultLocale")
    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;

        return (hours == 0 ? "--:" : hours + ":") + String.format("%02d:%02d", minutes % 60, seconds % 60);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            displayCurrentTime();
            mHandler.postDelayed(this, 100);
        }
    };
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (null == player) return;
        mPlayer = player;
        displayCurrentTime();

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
        player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        mPlayButtonLayout.setVisibility(View.VISIBLE);

        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(mPlayerStateChangeListener);
        player.setPlaybackEventListener(mPlaybackEventListener);
    }
    YouTubePlayer.PlaybackEventListener mPlaybackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
            mHandler.removeCallbacks(runnable);
        }

        @Override
        public void onPlaying() {
            mHandler.postDelayed(runnable, 100);
            displayCurrentTime();
        }

        @Override
        public void onSeekTo(int arg0) {
            mHandler.postDelayed(runnable, 100);
        }

        @Override
        public void onStopped() {
            mHandler.removeCallbacks(runnable);
        }
    };

    YouTubePlayer.PlayerStateChangeListener mPlayerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {}
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {}
        @Override
        public void onLoaded(String arg0) {}
        @Override
        public void onLoading() {}
        @Override
        public void onVideoEnded() {}
        @Override
        public void onVideoStarted() {
            displayCurrentTime();
        }
    };
    SeekBar.OnSeekBarChangeListener mVideoSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            long lengthPlayed = (mPlayer.getDurationMillis() * progress) / 100;
            mPlayer.seekToMillis((int) lengthPlayed);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar){}
    };
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }
}