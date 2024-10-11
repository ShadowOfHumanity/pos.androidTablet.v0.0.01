package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityDesert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert); // Set your layout for dessert selection

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityDesert.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });
        Button DesertButton1 = findViewById(R.id.button_desert_1);
        DesertButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Chocolate", "1.70");
                updateTotal();

            }
        });
        Button DesertButton2 = findViewById(R.id.button_desert_2);
        DesertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Cake", "1.50");
                updateTotal();

            }
        });
        Button DesertButton3 = findViewById(R.id.button_desert_3);
        DesertButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Croissant", "2.00");
                updateTotal();

            }
        });
        Button DesertButton4 = findViewById(R.id.button_desert_4);
        DesertButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Crisps (S)", "1.00");
                updateTotal();

            }
        });
        Button DesertButton5 = findViewById(R.id.button_desert_5);
        DesertButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Crisps (L)", "1.50");
                updateTotal();

            }
        });
        Button DesertButton6 = findViewById(R.id.button_desert_6);
        DesertButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Nuts", "1.00");
                updateTotal();

            }
        });
    }

    protected void updateTotal(){
        InsideOrder insideOrder = InsideOrder.getInstance();

        // Update the side panel texts whenever the activity is resumed
        insideOrder.updateAllTotals(findViewById(R.id.text_total));
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
