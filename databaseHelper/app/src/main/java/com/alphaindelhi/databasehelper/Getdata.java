package com.alphaindelhi.databasehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Getdata extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        textView = findViewById(R.id.textView);
        String myvalue = getIntent().getStringExtra("ID");
        textView.setText(myvalue);


    }
}
