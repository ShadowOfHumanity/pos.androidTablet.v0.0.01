package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityBeverages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevareges);

        Button buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityBeverages.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });

        findViewById(R.id.btn_hot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeveragesHotActivity(); // Call the method to navigate to the HOT Beverages Activity
            }
        });

        findViewById(R.id.btn_cold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBeveragesColdActivity(); // Call the method to navigate to the HOT Beverages Activity
            }
        });
    }

    public void goToBeveragesColdActivity() {
        Intent intent = new Intent(this, ActivityBeveragesCold.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToBeveragesHotActivity() {
        Intent intent = new Intent(this, ActivityBeveragesHot.class); // Create an intent for the new activity
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