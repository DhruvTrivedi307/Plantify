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

public class filter_size extends Fragment {

    CheckBox small, medium;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public filter_size() {
        // Required empty public constructor
    }

    public static filter_size newInstance(String param1, String param2) {
        filter_size fragment = new filter_size();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_size, container, false);
        small = view.findViewById(R.id.small);
        medium = view.findViewById(R.id.medium);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PlantFilterPrefs", Context.MODE_PRIVATE);
        small.setChecked(sharedPreferences.getBoolean("small_size", false));
        medium.setChecked(sharedPreferences.getBoolean("medium_size", false));

        small.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());
        medium.setOnCheckedChangeListener((buttonView, isChecked) -> saveState());

        return view;
    }

    private void saveState() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PlantFilterPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("small_size", small.isChecked());
        editor.putBoolean("medium_size", medium.isChecked());
        editor.apply();
    }
}