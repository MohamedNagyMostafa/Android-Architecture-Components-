package com.adja.apps.mohamednagy.androidarch.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adja.apps.mohamednagy.androidarch.R;
import com.adja.apps.mohamednagy.androidarch.database.AppDatabase;
import com.adja.apps.mohamednagy.androidarch.database.Note;
import com.adja.apps.mohamednagy.androidarch.databinding.FragmentAddNoteBinding;
import com.adja.apps.mohamednagy.androidarch.sync.AppExecutors;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddNoteActivityFragment extends Fragment {

    private AppDatabase mAppDatabase;
    private AppExecutors mAppExecutors;
    private FragmentAddNoteBinding mFragmentAddNoteBinding;

    public AddNoteActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_note, container, false);
        mFragmentAddNoteBinding = DataBindingUtil.bind(rootView);
        mAppDatabase = AppDatabase.getInstance(getContext());
        mAppExecutors = AppExecutors.getInstance();

        assert mFragmentAddNoteBinding != null;

        mFragmentAddNoteBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String auth = mFragmentAddNoteBinding.authEditText.getText().toString();
                String head = mFragmentAddNoteBinding.headEditText.getText().toString();
                String body = mFragmentAddNoteBinding.bodyEditText.getText().toString();

                int priority = mFragmentAddNoteBinding.seekBar.getProgress();
                Date date = (getCurrentDate());

                final Note note = new Note(auth, head, body, date, priority);

                mAppExecutors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        mAppDatabase.noteDao().insertNote(note);
                    }
                });


                close();
            }
        });

        return rootView;
    }

    private Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();

        return calendar.getTime();
    }

    private void close(){
        Activity activity = getActivity();
        if(activity != null)
            activity.finish();
    }

}
