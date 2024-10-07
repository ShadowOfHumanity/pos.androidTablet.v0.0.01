package com.example.jakeposv001;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityBeveragesCold extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_cold);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityBeveragesCold.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }

        });
        Button buttonColdBeverage1 = findViewById(R.id.button_cold_beverage_1);
        buttonColdBeverage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("SoftDrink", "2.00");
                updateTotal();
            }

        });
        Button buttonColdBeverage2 = findViewById(R.id.button_cold_beverage_2);
        buttonColdBeverage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Water", "1.00");
                updateTotal();
            }

        });
        Button buttonColdBeverage3 = findViewById(R.id.button_cold_beverage_3);
        buttonColdBeverage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Beer", "2.00");
                updateTotal();
            }

        });
        Button buttonColdBeverage4 = findViewById(R.id.button_cold_beverage_4);
        buttonColdBeverage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("SPRK WTR", "1.50");
                updateTotal();
            }

        });
        Button buttonColdBeverage5 = findViewById(R.id.button_cold_beverage_5);
        buttonColdBeverage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("FLVR WTR", "2.00");
                updateTotal();
            }

        });
        Button buttonColdBeverage6 = findViewById(R.id.button_cold_beverage_6);
        buttonColdBeverage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Getorade", "2.00");
                updateTotal();
            }

        });
        Button buttonColdBeverage7 = findViewById(R.id.button_cold_beverage_7);
        buttonColdBeverage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("Prime", "2.50");
                updateTotal();
            }

        });
        Button buttonColdBeverage8 = findViewById(R.id.button_cold_beverage_8);
        buttonColdBeverage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addData("NRG Drink", "2.00");
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