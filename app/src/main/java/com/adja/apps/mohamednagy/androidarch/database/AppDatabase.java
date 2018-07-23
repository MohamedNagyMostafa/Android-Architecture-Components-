package com.adja.apps.mohamednagy.androidarch.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    1:48 PM
 */
@Database(entities = {Note.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "andArch_db";
    private static final Object LOCK = new Object();

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        AppDatabase localRef = instance; // ignore shared memory copy, access directly to main memory
        // Prevent multiply threading Working synchronously
        if (localRef == null) {
            synchronized (LOCK) {
                instance = localRef = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        AppDatabase.DATABASE_NAME
                ).build();
            }
        }

        return localRef;
    }

    public abstract NoteDao noteDao();
}
