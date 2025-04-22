package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class filter_price extends Fragment {

    CheckBox air_plants,flowering_plants,climbers,water_plants,fruit_plants,ground_covers;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public filter_price() {
        // Required empty public constructor
    }

    RangeSlider priceRangeSlider;

    public static filter_price newInstance(String param1, String param2) {
        filter_price fragment = new filter_price();
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
        View view = inflater.inflate(R.layout.fragment_filter_price, container, false);

        priceRangeSlider = view.findViewById(R.id.priceRangeSlider);
        TextView rangeTextView = view.findViewById(R.id.range);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PlantFilterPrefs", Context.MODE_PRIVATE);
        float minPrice = sharedPreferences.getFloat("min_price", 100f); // Default to ₹100 if not saved
        float maxPrice = sharedPreferences.getFloat("max_price", 2000f); // Default to ₹2000 if not saved

        priceRangeSlider.setValues(minPrice, maxPrice);
        rangeTextView.setText("₹" + Math.round(minPrice) + " - ₹" + Math.round(maxPrice));

        priceRangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            float min = slider.getValues().get(0);
            float max = slider.getValues().get(1);
            List<Float> values = slider.getValues();
            String range = "₹" + Math.round(values.get(0)) + " - ₹" + Math.round(values.get(1));
            rangeTextView.setText(range);
            rangeTextView.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);

            // Save the selected price range
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putFloat("min_price", min);
            editor.putFloat("max_price", max);
            editor.apply();
        });

        return view;
    }
}