package com.adja.apps.mohamednagy.androidarch.ui;

import android.graphics.drawable.Drawable;

import com.adja.apps.mohamednagy.androidarch.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    6:15 PM
 */
public class Util {

    public static int colorSwitcher(int level){
        int colorId = -1;

        switch (level){
            case 1:
                colorId = R.drawable.priority_level_1;
                break;
            case 2:
                colorId = R.drawable.priority_level_1;
                break;
            case 3:
                colorId = R.drawable.priority_level_1;
                break;
            case 4:
                colorId = R.drawable.priority_level_1;
                break;
            case 5:
                colorId = R.drawable.priority_level_1;
                break;
            case 6:
                colorId = R.drawable.priority_level_1;
                break;
            case 7:
                colorId = R.drawable.priority_level_1;
                break;
            case 8:
                colorId = R.drawable.priority_level_1;
                break;
            case 9:
                colorId = R.drawable.priority_level_1;
                break;
            case 10:
                colorId = R.drawable.priority_level_1;
                break;

            default: return -1;
        }

        return colorId;
    }

    public static String dateToString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.US);

        return dateFormat.format(date);
    }
}
