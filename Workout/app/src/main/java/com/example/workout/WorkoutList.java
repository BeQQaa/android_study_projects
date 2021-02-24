package com.example.workout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorkoutList extends ListFragment {

    public interface Listener {
        void itemClicked(long id);
    }

    private Listener listener;

    @Override
    public void onAttach( @NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if (listener != null){
            listener.itemClicked(id);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.WORKOUTS.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.WORKOUTS[i].getName();
        }

        ArrayAdapter <String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_expandable_list_item_1,
                names
        );



        setListAdapter(adapter);
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}