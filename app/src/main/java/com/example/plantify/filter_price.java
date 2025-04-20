package com.example.plantify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link filter_price#newInstance} factory method to
 * create an instance of this fragment.
 */
public class filter_price extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public filter_price() {
        // Required empty public constructor
    }

    RangeSlider priceRangeSlider;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment filter_price.
     */
    // TODO: Rename and change types and number of parameters
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter_price, container, false);

        // Now you can safely access views from the layout
        priceRangeSlider = view.findViewById(R.id.priceRangeSlider);
        TextView rangeTextView = view.findViewById(R.id.range);

        // Set initial range values
        priceRangeSlider.setValues(100f, 2000f); // Note: use float values
        rangeTextView.setText("₹100 - ₹2000");

        // Optional: Add listener for changes
        priceRangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            float min = slider.getValues().get(0);
            float max = slider.getValues().get(1);
            // You can log or use min and max values here
            List<Float> values = slider.getValues();
            String range = "₹" + Math.round(values.get(0)) + " - ₹" + Math.round(values.get(1));
            rangeTextView.setText(range);
            rangeTextView.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
        });

        return view;
    }
}