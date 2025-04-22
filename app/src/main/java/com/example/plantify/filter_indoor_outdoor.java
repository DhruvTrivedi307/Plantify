package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

public class filter_indoor_outdoor extends Fragment {

    CheckBox indoor, outdoor, outdoor_shade_loving_plant, outdoor_sun_loving_plant;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public filter_indoor_outdoor() {
        // Required empty public constructor
    }

    public static filter_indoor_outdoor newInstance(String param1, String param2) {
        filter_indoor_outdoor fragment = new filter_indoor_outdoor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_filter_indoor_outdoor, container, false);
        indoor = view.findViewById(R.id.indoor);
        outdoor = view.findViewById(R.id.outdoor);
        outdoor_shade_loving_plant = view.findViewById(R.id.outdoor_shade_loving_plant);
        outdoor_sun_loving_plant = view.findViewById(R.id.outdoor_sun_loving_plant);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PlantFilterPrefs", Context.MODE_PRIVATE);
        indoor.setChecked(sharedPreferences.getBoolean("indoor", false));
        outdoor.setChecked(sharedPreferences.getBoolean("outdoor", false));
        outdoor_shade_loving_plant.setChecked(sharedPreferences.getBoolean("outdoor_shade_loving", false));
        outdoor_sun_loving_plant.setChecked(sharedPreferences.getBoolean("outdoor_sun_loving", false));

        indoor.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        outdoor.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        outdoor_shade_loving_plant.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        outdoor_sun_loving_plant.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());

        return view;
    }

    private void saveState() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PlantFilterPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("indoor", indoor.isChecked());
        editor.putBoolean("outdoor", outdoor.isChecked());
        editor.putBoolean("outdoor_shade_loving", outdoor_shade_loving_plant.isChecked());
        editor.putBoolean("outdoor_sun_loving", outdoor_sun_loving_plant.isChecked());
        editor.apply();
    }
}