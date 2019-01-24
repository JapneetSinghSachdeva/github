package com.alphaindelhi.databasehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewAll extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        textView = findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());


        String myvalue = getIntent().getStringExtra("ID");
        textView.setText(myvalue);




    }
}
