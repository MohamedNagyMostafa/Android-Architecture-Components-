package com.adja.apps.mohamednagy.androidarch.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adja.apps.mohamednagy.androidarch.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddNoteActivityFragment extends Fragment {

    public AddNoteActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }
}
