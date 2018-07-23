package com.adja.apps.mohamednagy.androidarch.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.adja.apps.mohamednagy.androidarch.MainActivity;
import com.adja.apps.mohamednagy.androidarch.R;
import com.adja.apps.mohamednagy.androidarch.database.Note;
import com.adja.apps.mohamednagy.androidarch.databinding.NoteItemBinding;

import java.util.List;

/**
 * Created by Mohamed Nagy on 7/23/2018 .
 * Project android_project
 * Time    5:59 PM
 */
public class NoteAdapter extends ArrayAdapter<Note> {
    private List<Note> mNotes;

    public NoteAdapter(@NonNull Context context) {
        super(context, 0);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Note note = mNotes.get(position);
        NoteItemBinding noteItemBinding;

        if(convertView == null)
            noteItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.note_item, parent, false);
        else
            noteItemBinding = DataBindingUtil.bind(convertView);

        assert noteItemBinding != null;

        noteItemBinding.authorTextView.setText(note.getAuthor());
        noteItemBinding.headTextView.setText(note.getHead());
        noteItemBinding.bodyTextView.setText(note.getBody());
        noteItemBinding.dateTextView.setText(Util.dateToString(note.getUpdatedAt()));
        int pe = note.getPriority();
        Log.e("int ttt test", "" +pe);
        noteItemBinding.priorityValue.setText(String.valueOf(pe));
        noteItemBinding.priorityFrame.setBackground(parent.getContext().getDrawable(Util.colorSwitcher(note.getPriority())));

        return noteItemBinding.getRoot();
    }

    public void swapList(List<Note> notes){
        mNotes = notes;
        notifyDataSetChanged();
    }

    public List<Note> getNotes() {
        return mNotes;
    }

    @Override
    public int getCount() {
        return mNotes == null?0: mNotes.size();
    }

}
