package com.example.android.areyoukittyme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TimerActivity extends AppCompatActivity {

    private Button timerStartBtn;
    private Button timerBackBtn;
    private EditText hourEditText;
    private Spinner minSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        this.timerStartBtn = (Button) findViewById(R.id.timerStartBtn);
        this.timerStartBtn = (Button) findViewById(R.id.timerStartBtn);

        this.minSpinner = (Spinner) findViewById(R.id.minSpinner);
        String[] items = new String[]{"Minutes", "00", "10", "20", "30", "40", "50"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        this.minSpinner.setAdapter(adapter);

        // enable back button to main page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
