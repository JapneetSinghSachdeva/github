package com.example.japneet.randombackgroundgenerator;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
   //ImageButton button ;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

       //  button = findViewById(R.id.button);

//         button.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 int color = Color.argb(255 ,  random.nextInt(256),random.nextInt(256),random.nextInt(256));
//
//                 layout.setBackgroundColor(color);
//
//             }
//         });
    }

public void button (View v){

        int color = Color.argb(255 , random.nextInt(256), random.nextInt(256), random.nextInt(256) );
        layout.setBackgroundColor(color);

}
}
