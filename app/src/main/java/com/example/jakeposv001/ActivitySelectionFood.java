package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySelectionFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_food);

        Button buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivitySelectionFood.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });

        findViewById(R.id.btn_pastizzeria).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPastizzeriaActivity();
            }
        });

        findViewById(R.id.btn_hobz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHobzActivity();
            }
        });

        findViewById(R.id.btn_desert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDesertActivity();
            }
        });
    }

    public void goToPastizzeriaActivity() {
        Intent intent = new Intent(this, ActivityPastizzeria.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToHobzActivity() {
        Intent intent = new Intent(this, ActivityHobz.class); // Create an intent for the new activity
        startActivity(intent); // Start the new activity
    }
    public void goToDesertActivity() {
        Intent intent = new Intent(this, ActivityDesert.class); // Create an intent for the new activity
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