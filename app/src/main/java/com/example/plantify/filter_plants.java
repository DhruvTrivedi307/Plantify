package com.example.plantify;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class filter_plants extends Fragment {

    CheckBox air_plants, flowering_plants, climbers;
    private static final String PREFS_NAME = "PlantFilterPrefs";
    private static final String AIR_PLANTS_KEY = "air_plants";
    private static final String FLOWERING_PLANTS_KEY = "flowering_plants";
    private static final String CLIMBERS_KEY = "climbers";

    public filter_plants() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_plants, container, false);

        air_plants = view.findViewById(R.id.air_plants);
        flowering_plants = view.findViewById(R.id.flowering_plants);
        climbers = view.findViewById(R.id.climbers);

        // Load the saved state
        loadSavedPreferences();

        // Set up listeners to save state when values are changed
        setUpCheckboxListeners();

        return view;
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        air_plants.setChecked(sharedPreferences.getBoolean(AIR_PLANTS_KEY, false));
        flowering_plants.setChecked(sharedPreferences.getBoolean(FLOWERING_PLANTS_KEY, false));
        climbers.setChecked(sharedPreferences.getBoolean(CLIMBERS_KEY, false));
    }

    private void setUpCheckboxListeners() {
        air_plants.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        flowering_plants.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        climbers.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
    }

    private void saveState() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(AIR_PLANTS_KEY, air_plants.isChecked());
        editor.putBoolean(FLOWERING_PLANTS_KEY, flowering_plants.isChecked());
        editor.putBoolean(CLIMBERS_KEY, climbers.isChecked());
        editor.apply();
    }
}