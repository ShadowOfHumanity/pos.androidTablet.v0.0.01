package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityBeveragesHot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_hot);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityBeveragesHot.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });
        Button buttonHotBeverage1 = findViewById(R.id.button_hot_beverage_1);
        buttonHotBeverage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Tea", "0.60");
                updateTotal();
            }
        });
        Button buttonHotBeverage2 = findViewById(R.id.button_hot_beverage_2);
        buttonHotBeverage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Coffee", "0.60");
                updateTotal();
            }
        });
        Button buttonHotBeverage3 = findViewById(R.id.button_hot_beverage_3);
        buttonHotBeverage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Capuccino", "1.50");
                updateTotal();
            }
        });
        Button buttonHotBeverage4 = findViewById(R.id.button_hot_beverage_4);
        buttonHotBeverage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Espresso", "1");
                updateTotal();
            }
        });
        Button buttonHotBeverage5 = findViewById(R.id.button_hot_beverage_5);
        buttonHotBeverage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Americano", "1.50");
                updateTotal();
            }
        });
        Button buttonHotBeverage6 = findViewById(R.id.button_hot_beverage_6);
        buttonHotBeverage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Latte", "1.50");
                updateTotal();
            }
        });
        Button buttonHotBeverage7 = findViewById(R.id.button_hot_beverage_7);
        buttonHotBeverage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Hot CHOC", "2.00");
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