package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFinishOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                InsideOrder insideOrder = InsideOrder.getInstance();

                insideOrder.resetNewTotal();
                Intent intent = new Intent(ActivityFinishOrder.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });
        Button button1Eur = findViewById(R.id.btn_1eur);
        button1Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(1.00, view, change);

            }
        });
        Button button2Eur = findViewById(R.id.btn_2eur);
        button2Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(2.00, view, change);

            }
        });
        Button button5Eur = findViewById(R.id.btn_5eur);
        button5Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(5.00, view, change);

            }
        });
        Button button10Eur = findViewById(R.id.btn_10eur);
        button10Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(10.00, view, change);

            }
        });
        Button button20Eur = findViewById(R.id.btn_20eur);
        button20Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(20.00, view, change);

            }
        });
        Button button50Eur = findViewById(R.id.btn_50eur);
        button50Eur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(50.00, view, change);

            }
        });
        Button buttonEnter = findViewById(R.id.btn_enter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                EditText amountInput = findViewById(R.id.edit_amount_input);
                String text = amountInput.getText().toString();
                double amount = Double.parseDouble(text);
                if (amount>0) {
                    insideOrder.updateFinishedTotal(amount, view, change);
                }
            }
        });
        Button buttonCardPayment = findViewById(R.id.btn_card_payment);
        buttonCardPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsideOrder insideOrder = InsideOrder.getInstance();

                TextView view = findViewById(R.id.text_total_amount);
                TextView change = findViewById(R.id.text_change);
                insideOrder.updateFinishedTotal(insideOrder.getNewTotal(), view, change);
            }
        });


    }
    protected void onResume() {
        super.onResume();

        // Get the singleton instance of InsideOrder
        InsideOrder insideOrder = InsideOrder.getInstance();

        // Update the side panel texts whenever the activity is resumed
        TextView view = findViewById(R.id.text_total_amount);
        TextView change = findViewById(R.id.text_change);
        insideOrder.updateFinishedTotal(0.00, view, change);
    }
}