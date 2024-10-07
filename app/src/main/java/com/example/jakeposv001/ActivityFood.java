package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityFood.this, ActivityMain.class);
                startActivity(intent);

            }
        });
        Button FoodButton1 = findViewById(R.id.button_food_1);
        FoodButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Pastizzi", "0.70");
                updateTotal();

            }
        });
        Button FoodButton2 = findViewById(R.id.button_food_2);
        FoodButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Pizza", "1.70");
                updateTotal();

            }
        });
        Button FoodButton3 = findViewById(R.id.button_food_3);
        FoodButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Pizza (R)", "2.00");
                updateTotal();

            }
        });
        Button FoodButton4 = findViewById(R.id.button_food_4);
        FoodButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Wudy", "1.60");
                updateTotal();

            }
        });
        Button FoodButton5 = findViewById(R.id.button_food_5);
        FoodButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("CHKN Pie", "2.20");
                updateTotal();

            }
        });
        Button FoodButton6 = findViewById(R.id.button_food_6);
        FoodButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Meat Pie", "2.20");
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