package com.example.full_stack_assessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Main Activity class holds the logic for the forecast btn
 * The forecast btn starts the ForecastActivity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ToDO: Create the forecast button listener to transition to the next activity
        LinearLayout forecastButton = (LinearLayout) findViewById(R.id.forecastBtn);


        forecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForecastActivity.class));
            }
        });

    }




}