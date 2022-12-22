package com.example.full_stack_assessment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.full_stack_assessment.Data.Forecast.Period;
import com.example.full_stack_assessment.Data.Forecast.Weather;
import com.example.full_stack_assessment.Data.IconsProperties;
import com.example.full_stack_assessment.ViewModels.APIStatus;
import com.example.full_stack_assessment.ViewModels.ForecastViewModel;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import java.util.HashMap;

/**
 * ForeCast activity navigates and manages calling the weather api
 * populating the resulting data into the forecast card
 */
public class ForecastActivity extends AppCompatActivity {

    //View model where all network calls are being preformed
    private ForecastViewModel forecastViewModel;
    //Hashmap containing possible forecasts and their corresponding icons
    private HashMap<String,Integer> forecastMap = new HashMap<String, Integer>(){{
        put("Sunny",R.drawable.ic_sun);
        put("Rain", R.drawable.ic_rain);
        put("Partially Sunny", R.drawable.ic_part_cloud);
        put("Mostly Sunny", R.drawable.ic_part_cloud);
        put("Partly Cloudy", R.drawable.ic_part_cloud);
        put("Snow",R.drawable.ic_snow);
        put("Cloud",R.drawable.ic_cloud);
        put("Cloudy",R.drawable.ic_cloud);
    }};

    //Method to return HashMap value based on key
    //Since there are a lot of different short forecasts, check if short forecast key in hashmap, if not, return icon from API
    //If key in hashmap return resource of drawable in hashmap
    private IconsProperties getIcon(String key, Period forecastObj) {
        IconsProperties iconsProperties = new IconsProperties();
        System.out.println("key: " + key);
        if (forecastMap.containsKey(key) == false) {
            System.out.println("NO KEY IN MAP USE: " + forecastObj.getIcon());
            iconsProperties.setUrl(true);
            String src = forecastObj.getIcon();
            iconsProperties.setImageUrl(src);
        } else {
            iconsProperties.setUrl(false);
            iconsProperties.setImageResource(forecastMap.get(key));
        }
        return iconsProperties;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        //Back button to navigate back to home page for easy re-forecast
        Button backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        forecastViewModel = new ForecastViewModel();

        //ToDo: Fetch the results from the ViewModel and populate the forecast card
        TextView forecastText = (TextView) findViewById(R.id.text_view_time);
        TextView degreeText = (TextView) findViewById(R.id.text_view_degree);
//        TextView shortForecast = (TextView) findViewById(R.id.shortF);
        ImageView forecastImg = (ImageView) findViewById(R.id.image_view_forecast);
        TextView errorText = (TextView) findViewById(R.id.errorMessage);

        forecastViewModel.getWeather().observe(this, new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                try{
                    //Initialize forecast period 0 (today)
                    Period todayForecast = weather.getProperties().getPeriods().get(0);
                    //Initialize Icon Object properties
                    IconsProperties iconObj = getIcon(todayForecast.getShortForecast(), todayForecast);

                    forecastText.setText(todayForecast.getName() + ": ");
                    degreeText.setText(todayForecast.getTemperature().toString() + todayForecast.getTemperatureUnit());
//                shortForecast.setText(todayForecast.getShortForecast());
                    if (!iconObj.getUrl()) {
                        forecastImg.setImageResource(iconObj.getImageResource());
                    } else {
                        Picasso.get().load(iconObj.getImageUrl()).into(forecastImg);
                    }

                }catch(Exception e){
                    forecastText.setText("API ERROR");
                    forecastText.setTextColor(Color.RED);
                    errorText.setText(e.toString());
                    System.out.println(("Error: " + e.toString()));
                }


            }
        });
    }

}