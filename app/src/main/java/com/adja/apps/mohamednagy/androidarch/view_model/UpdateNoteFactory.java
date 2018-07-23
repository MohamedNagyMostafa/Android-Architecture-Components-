package com.adja.apps.mohamednagy.androidarch.view_model;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    11:27 PM
 */
public class UpdateNoteFactory extends ViewModelProvider.NewInstanceFactory {

    private int mNoteId;
    private AppDatabase mAppDatabase;

    public UpdateNoteFactory(int noteId, AppDatabase appDatabase){
        mNoteId = noteId;
        mAppDatabase = appDatabase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UpdateNoteViewModel(mNoteId, mAppDatabase);
    }
}
