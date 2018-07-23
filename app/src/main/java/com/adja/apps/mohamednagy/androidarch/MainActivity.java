package com.adja.apps.mohamednagy.androidarch;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;
import com.adja.apps.mohamednagy.androidarch.database.Note;
import com.adja.apps.mohamednagy.androidarch.ui.AddNoteActivity;
import com.adja.apps.mohamednagy.androidarch.ui.NoteAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;
    private NoteAdapter mNoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppDatabase = AppDatabase.getInstance(getApplicationContext());
        mNoteAdapter = new NoteAdapter(this);

        ListView listView = findViewById(R.id.note_list);
        FloatingActionButton floatingActionButton = findViewById(R.id.add_new_note_btn);

        listView.setAdapter(mNoteAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> notes = mAppDatabase.noteDao().loadAllNotes();
        mNoteAdapter.swapList(notes);
    }

}
