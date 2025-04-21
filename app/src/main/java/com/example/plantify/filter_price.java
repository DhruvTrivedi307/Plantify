package com.example.plantify;

import android.annotation.SuppressLint;
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

        air_plants = view.findViewById(R.id.air_plants);
        flowering_plants = view.findViewById(R.id.flowering_plants);
        climbers = view.findViewById(R.id.climbers);
        water_plants = view.findViewById(R.id.water_plants);
        fruit_plants = view.findViewById(R.id.fruit_plants);

        priceRangeSlider = view.findViewById(R.id.priceRangeSlider);
        TextView rangeTextView = view.findViewById(R.id.range);

        priceRangeSlider.setValues(100f, 2000f);
        rangeTextView.setText("₹100 - ₹2000");

        priceRangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            float min = slider.getValues().get(0);
            float max = slider.getValues().get(1);
            List<Float> values = slider.getValues();
            String range = "₹" + Math.round(values.get(0)) + " - ₹" + Math.round(values.get(1));
            rangeTextView.setText(range);
            rangeTextView.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
        });

        FilterViewModel viewModel = new ViewModelProvider(requireActivity()).get(FilterViewModel.class);

        priceRangeSlider.setValues(viewModel.minPrice.getValue(), viewModel.maxPrice.getValue());

        priceRangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            float min = slider.getValues().get(0);
            float max = slider.getValues().get(1);
            viewModel.minPrice.setValue(min);
            viewModel.maxPrice.setValue(max);
        });

        return view;
    }
}