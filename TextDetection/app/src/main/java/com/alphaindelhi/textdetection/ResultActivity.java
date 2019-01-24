package com.alphaindelhi.textdetection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


public Button back_button;
public TextView resultTextview;
public String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);



        back_button = findViewById(R.id.back_button);
        resultTextview = findViewById(R.id.result_textview);



        resultText = getIntent().getStringExtra(TextRecognization.RESULT_TEXT);


        resultTextview.setText(resultText);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
