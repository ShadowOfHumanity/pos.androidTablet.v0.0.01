package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHobz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobz);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityHobz.this, ActivityMain.class);
                startActivity(intent);

            }
        });
        Button FoodButton1 = findViewById(R.id.button_hobz_1);
        FoodButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Foccia", "3.50");
                updateTotal();

            }
        });
        Button FoodButton2 = findViewById(R.id.button_hobz_2);
        FoodButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("BAGET (H)", "3.00");
                updateTotal();

            }
        });
        Button FoodButton3 = findViewById(R.id.button_hobz_3);
        FoodButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("BAGET (C)", "3.80");
                updateTotal();

            }
        });
        Button FoodButton4 = findViewById(R.id.button_hobz_4);
        FoodButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("BAGET (L)", "3.80");
                updateTotal();

            }
        });
        Button FoodButton5 = findViewById(R.id.button_hobz_5);
        FoodButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Ftira (EB)", "3.50");
                updateTotal();

            }
        });
        Button FoodButton6 = findViewById(R.id.button_hobz_6);
        FoodButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Ftira (EBS)", "4.00");
                updateTotal();

            }
        });
        Button FoodButton7 = findViewById(R.id.button_hobz_7);
        FoodButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Ftira (EST)", "3.80");
                updateTotal();

            }
        });
        Button FoodButton8 = findViewById(R.id.button_hobz_8);
        FoodButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Ftira (F)", "5.00");
                updateTotal();

            }
        });
        Button FoodButton9 = findViewById(R.id.button_hobz_9);
        FoodButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Ftira (T)", "3.00");
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