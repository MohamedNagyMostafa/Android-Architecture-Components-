package com.adja.apps.mohamednagy.androidarch;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;
import com.adja.apps.mohamednagy.androidarch.database.Note;
import com.adja.apps.mohamednagy.androidarch.sync.AppExecutors;
import com.adja.apps.mohamednagy.androidarch.ui.AddNoteActivity;
import com.adja.apps.mohamednagy.androidarch.ui.NoteAdapter;
import com.adja.apps.mohamednagy.androidarch.view_model.MainViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;
    private NoteAdapter mNoteAdapter;
    private AppExecutors mAppExecutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppDatabase = AppDatabase.getInstance(getApplicationContext());
        mNoteAdapter = new NoteAdapter(this);
        mAppExecutors = AppExecutors.getInstance();

        ListView listView = findViewById(R.id.note_list);
        FloatingActionButton floatingActionButton = findViewById(R.id.add_new_note_btn);

        listView.setAdapter(mNoteAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, final View view, int i, long l) {
                mAppExecutors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<Note> notes = mNoteAdapter.getNotes();
                        int position = adapterView.getPositionForView(view);

                        mAppDatabase.noteDao().deleteNote(notes.get(position));
                    }
                });
            }
        });

        setupViewModel();
    }

    private void setupViewModel(){
        // Run on Outer Thread by default
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                // Run in UI Thread by default
                mNoteAdapter.swapList(notes);
            }
        });
    }

}
