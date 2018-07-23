package com.adja.apps.mohamednagy.androidarch.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;
import com.adja.apps.mohamednagy.androidarch.database.Note;

import java.util.List;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    11:15 PM
 */
public class MainViewModel extends AndroidViewModel {

    private LiveData<List<Note>> notes;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase appDatabase = AppDatabase.getInstance(this.getApplication());
        notes = appDatabase.noteDao().loadAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }
}
