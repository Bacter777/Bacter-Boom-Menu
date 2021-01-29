package com.bacter.boommenu.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import com.bacter.boommenu.R;
import com.bacter.boommenu.boom.BuilderManager;
import com.bacter.boommenu.triskelion_activities.CodesOfConductActivity;
import com.bacter.boommenu.triskelion_activities.PrayerActivity;
import com.bacter.boommenu.triskelion_activities.PreambleActivity;
import com.bacter.boommenu.triskelion_activities.TenetsActivity;
import com.bacter.boommenu.wallpaper.WallpaperActivity;
import com.bacter.boommenu.youtubeless.HymnActivity;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity
{
    Executor executor;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    private WindowManager mWindowManager;


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback()
        {
            // IF WRONG FINGERPRINT.. THIS WILL FORCE-CLOSE THE APP
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(MainActivity.this, "MUANG YOU!!" + errString, Toast.LENGTH_LONG).show();
                MainActivity.this.finish();
            }
            // IF AUTHENTICATION IS SUCCESSFUL
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(MainActivity.this, "AUTHENTICATION SUCCESSFOOOOL!" + result, Toast.LENGTH_LONG).show();
            }
            // IF NO FINGERPRINT SENSOR DETECTED ON DEVICE
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(MainActivity.this, "MUANG YOU!!", Toast.LENGTH_LONG).show();
            }
        });
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Developed by:BdFreak")
                .setDescription("Touch ID Required")
                .setNegativeButtonText("Exit")
                .build();
        biometricPrompt.authenticate(promptInfo);

        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        BoomMenuButton bmb = findViewById(R.id.bmb);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        assert bmb != null;
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_9_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_9_1);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++)
            bmb.addBuilder(BuilderManager.getSquareCircleButtonBuilder());
        bmb.setDraggable(true);
        bmb.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if (index == 0) {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), PrayerActivity.class));
                    overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
                } else if (index == 1) {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), WallpaperActivity.class));
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                } else if (index == 2) {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), CodesOfConductActivity.class));
                    overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
                } else if (index == 3) {
                    // IF APP IS INSTALLED, THEN START THE ACTIVITY
                    Intent facebookIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                    if (facebookIntent != null) {
                        facebookIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    } else {
                        // IF APP IS NOT INSTALLED, THEN OPEN GOOGLE PLAY
                        Toast.makeText(getApplicationContext(), "Facebook Not Installed! \n\nOpening Google Play Now!", Toast.LENGTH_LONG).show();
                        facebookIntent = new Intent(Intent.ACTION_VIEW);
                        facebookIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        facebookIntent.setData(Uri.parse("market://details?id=" + "com.facebook.katana"));
                    }
                    startActivity(facebookIntent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 4) {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                } else if (index == 5) {
                    Intent messengerIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.orca");
                    if (messengerIntent != null) {
                        // IF APP IS FOUND or INSTALLED, THEN START THE ACTIVITY
                        messengerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    } else {
                        // IF APP NOT INSTALLED, THEN OPEN GOOGLE PLAY
                        Toast.makeText(getApplicationContext(), "Oopss.. Messenger Not Installed! \n\nOpening Google Play Now!", Toast.LENGTH_LONG).show();
                        messengerIntent = new Intent(Intent.ACTION_VIEW);
                        messengerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        messengerIntent.setData(Uri.parse("market://details?id=" + "com.facebook.orca"));
                    }
                    startActivity(messengerIntent);
                } else if (index == 6) {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), HymnActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 7)//PRAYER
                {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), PreambleActivity.class));
                    overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
                } else if (index == 8)//TENETS
                {
                    MainActivity.this.startActivity(new Intent(getApplicationContext(), TenetsActivity.class));
                    overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
                }
            }

            @Override
            public void onBackgroundClick() {
            }

            @Override
            public void onBoomWillHide() {
            }

            @Override
            public void onBoomDidHide() {
            }

            @Override
            public void onBoomWillShow() {
            }

            @Override
            public void onBoomDidShow() {

            }
        });
    }
    public void onBackPressed() {
        AlertDialog.Builder boombac = new AlertDialog.Builder(this);
        boombac.setIcon(R.drawable.cert_dev);
        boombac.setTitle(R.string.app_name);
        boombac.setMessage("Exit Bacter Boom Menu?");
        boombac.setCancelable(false);
        boombac.setPositiveButton("EXIT", (dialog, which) -> MainActivity.this.finish());
        boombac.setNegativeButton("NO", (dialog, which) -> dialog.dismiss());
        boombac.setNeutralButton("CANCEL", (dialog, which) -> Toast.makeText(getApplicationContext(), "CANCELLED", Toast.LENGTH_SHORT).show());
        boombac.create();
        boombac.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId()== R.id.boom_about)
        {
            MainActivity.this.startActivity(new Intent(getApplicationContext(),AboutActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        }
        if (item.getItemId()== R.id.boom_exit)
        {
            AlertDialog.Builder bacterCute = new AlertDialog.Builder(this);
            bacterCute.setTitle(R.string.app_name);
            bacterCute.setIcon(R.drawable.cert_dev);
            bacterCute.setMessage("Exit Bacter Boom Menu?");
            bacterCute.setCancelable(false);
            bacterCute.setPositiveButton("EXIT", (dialog, which) -> MainActivity.this.finish());
            bacterCute.setNegativeButton("NO", (dialog, which) -> dialog.dismiss());
            bacterCute.setNeutralButton("CANCEL", (dialog, which) -> Toast.makeText(getApplicationContext(),"CANCELLED",Toast.LENGTH_SHORT).show());
            bacterCute.create();
            bacterCute.show();
        }
        return super.onOptionsItemSelected(item);
    }
}