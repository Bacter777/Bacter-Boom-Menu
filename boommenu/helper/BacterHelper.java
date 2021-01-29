package com.bacter.boommenu.helper;

import android.app.Activity;
import android.content.Intent;
import android.widget.FrameLayout;

import com.bacter.boommenu.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class BacterHelper
{
    private final Activity activity;
    private BacterHelper(Activity activity)
    {
        this.activity = activity;
    }
    public static BacterHelper with(Activity activity)
    {
        return new BacterHelper(activity);
    }
    public void loadAbout()
    {
        final FrameLayout frameAbout = activity.findViewById(R.id.frameAbout);
        AboutBuilder builder = AboutBuilder.with(activity)
                .setAppIcon(R.drawable.cert_dev)
                .setAppName(R.string.app_name)
                .setPhoto(R.drawable.dev)
                .setCover(R.drawable.cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setDividerColor(R.color.colorAccent)
                .setName("BdFreak")
                .setNameColor(R.color.colorPrimary)
                .setLinksColumnsCount(3)
                .setLinksAnimated(true)
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover. \nBuild with ❤")
                .setBriefColor(android.R.color.holo_red_dark)
                .addGitHubLink("Bacter777")
                .addFacebookLink("BdFreak777")
                .addEmailLink("bdfreak777@gmail.com")
                .addFiveStarsAction()
                .addMoreFromMeAction("bdfreak")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setActionsColumnsCount(2)
                .addFeedbackAction("bdfreak777@gmail.com")
                .addIntroduceAction((Intent)null)
                .addChangeLogAction((Intent)null)
                .addRemoveAdsAction((Intent)null)
                .addDonateAction((Intent)null)
                .setWrapScrollView(true)
                .setShowAsCard(true);
        AboutView view = builder.build();
        frameAbout.addView(view);
    }
}
