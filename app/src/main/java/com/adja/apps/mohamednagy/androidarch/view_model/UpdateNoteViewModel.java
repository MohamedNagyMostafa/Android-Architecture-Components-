package com.adja.apps.mohamednagy.androidarch.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;
import com.adja.apps.mohamednagy.androidarch.database.Note;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    11:30 PM
 */
public class UpdateNoteViewModel extends ViewModel{
    private LiveData<Note> mNote;

    public UpdateNoteViewModel(int mNoteId, AppDatabase database){
        mNote = database.noteDao().loadNoteById(mNoteId);
    }

    public LiveData<Note> getNote() {
        return mNote;
    }
}
