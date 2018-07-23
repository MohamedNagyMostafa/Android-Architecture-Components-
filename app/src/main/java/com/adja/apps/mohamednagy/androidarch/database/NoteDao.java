package com.adja.apps.mohamednagy.androidarch.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    1:26 PM
 */
@Dao
public interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY  priority")
    List<Note> loadAllNotes();
    @Insert
    void insertNote(Note note);
    @Delete
    void deleteNote(Note note);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateNote(Note note);
}
