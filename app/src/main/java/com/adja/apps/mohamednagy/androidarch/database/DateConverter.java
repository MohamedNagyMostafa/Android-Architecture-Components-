package com.adja.apps.mohamednagy.androidarch.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    2:08 PM
 */
public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null? null: new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date){
        return date == null? null: date.getTime();
    }
}
