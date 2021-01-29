package com.bacter.boommenu.boom;

import com.bacter.boommenu.R;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.Util;

public class BuilderManager
{
    private static final int[] imageResources = new int[]{
            R.drawable.boom_home, //0
            R.drawable.boo_gallery,//1
            R.drawable.boom_codesofconduct, // 2
            R.drawable.boom_facebook, // 3
            R.drawable.boom_info, // 4
            R.drawable.boom_messenger, // 5
            R.drawable.boom_video,// 6
            R.drawable.boom_prayer, // 7
            R.drawable.boom_tenets,//8
    };
    private static final int[]imageResources2 = new int[]{
            R.drawable.boom_tenets,
            R.drawable.boom_codesofconduct,
            R.drawable.boom_prayer,
            R.drawable.boom_video,
            R.drawable.boom_info,
            R.drawable.boom_exit
    };
    private static int imagetResourceIndex2 = 1;
    static int getImagetResource2()
    {
        if (imagetResourceIndex2 >= imageResources2.length)imagetResourceIndex2 =1;
        return imageResources2[imagetResourceIndex2++];
    }
    private static int imageresourceIndex = 0;
    static int getImageResource()
    {
        if (imageresourceIndex >= imageResources.length)imageresourceIndex = 0;
        return imageResources[imageresourceIndex++];
    }
    public static SimpleCircleButton.Builder getSquareCircleButtonBuilder()
    {
        return new SimpleCircleButton.Builder()
                .isRound(false)
                .shadowCornerRadius(Util.dp2px(20))
                .buttonCornerRadius(Util.dp2px(20))
                .normalImageRes(getImageResource());
    }

}
