package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for this activity

        // Setup button click listener for the Food button
        findViewById(R.id.btn_food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFoodActivity(); // Call the method to navigate to the Food Activity
            }
        });
        findViewById(R.id.btn_beverages).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeveragesActivity(); // Call the method to navigate to the Food Activity
            }
        });
        findViewById(R.id.btn_add_extra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExtraActivity(); // Call the method to navigate to the Food Activity
            }
        });
        findViewById(R.id.btn_void).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVoidActivity(); // Call the method to navigate to the Food Activity
            }
        });
        findViewById(R.id.btn_finish_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFinishOrderActivity(); // Call the method to navigate to the Food Activity
            }
        });
        findViewById(R.id.btn_today_total).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTodayTotalActivity(); // Call the method to navigate to the Food Activity
            }
        });
    }

    public void goToTodayTotalActivity(){
        Intent intent = new Intent(this, ActivityTodayTotal.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToFinishOrderActivity(){
        Intent intent = new Intent(this, ActivityFinishOrder.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToVoidActivity(){
        Intent intent = new Intent(this, ActivitySelectVoid.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToExtraActivity(){
        Intent intent = new Intent(this, ActivityExtra.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToBeveragesActivity() {
        Intent intent = new Intent(this, ActivityBeverages.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToFoodActivity() {
        Intent intent = new Intent(this, ActivityFood.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Get the singleton instance of InsideOrder
        InsideOrder insideOrder = InsideOrder.getInstance();

        // Update the side panel texts whenever the activity is resumed
        insideOrder.updateAllTotals(findViewById(R.id.text_total));
    }

}
