package com.example.plantify;

import static com.example.plantify.search_results_activity.name;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {

    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText searchInput = findViewById(R.id.search);
        searchInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                String query = searchInput.getText().toString();
                if (!query.isEmpty()) {
                    performSearch(query);
                }
                return true;
            }
            return false;
        });

        RecyclerView suggestionList = findViewById(R.id.suggestionsRecyclerView);
        List<String> allItems = name; // ← use your previously created `name` list
        SuggestionAdapter adapter = new SuggestionAdapter(new ArrayList<>(), selected -> {
            searchInput.setText(selected);
            performSearch(selected);
            suggestionList.setVisibility(View.GONE);
        });

        suggestionList.setLayoutManager(new LinearLayoutManager(this));
        suggestionList.setAdapter(adapter);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().trim().toLowerCase();
                if (!query.isEmpty()) {
                    List<String> filtered = new ArrayList<>();
                    for (String item : allItems) {
                        if (item.toLowerCase().contains(query)) {
                            filtered.add(item);
                        }
                    }
                    adapter.updateData(filtered);

                    if (!filtered.isEmpty()) {
                        suggestionList.setVisibility(View.VISIBLE);
                    } else {
                        suggestionList.setVisibility(View.GONE);
                    }
                } else {
                    suggestionList.setVisibility(View.GONE);
                }
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        back = findViewById(R.id.back);

        back.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.fade_out);
    }

    private void performSearch(String query) {
        Intent intent = new Intent(this, search_results_activity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

}