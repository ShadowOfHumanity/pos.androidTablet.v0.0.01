package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityExtra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityExtra.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });
        Button btn0 = findViewById(R.id.btn_0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"0");

            }
        });
        Button btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"1");

            }
        });
        Button btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"2");

            }
        });
        Button btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"3");

            }
        });
        Button btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"4");

            }
        });
        Button btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"5");

            }
        });
        Button btn6 = findViewById(R.id.btn_6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"6");

            }
        });
        Button btn7 = findViewById(R.id.btn_7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"7");

            }
        });
        Button btn8 = findViewById(R.id.btn_8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"8");

            }
        });
        Button btn9 = findViewById(R.id.btn_9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"9");

            }
        });
        Button btn_dec = findViewById(R.id.btn_decimal);
        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+".");

            }
        });
        Button btn_mul = findViewById(R.id.btn_multiply);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                panel.setText(text+"*");
            }
        });
        Button btn_ad = findViewById(R.id.btn_add);
        btn_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                InsideOrder insideOrder = InsideOrder.getInstance();
                insideOrder.addExtraProd(text);
                updateTotal();
            }
        });
        Button btn_dl = findViewById(R.id.btn_del);
        btn_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView panel = findViewById(R.id.text_result);
                String text = (String) panel.getText();
                String modifiedString = "";
                if (text.length() > 0) {
                    modifiedString = text.substring(0, text.length() - 1);
                } try {} catch (Exception ignored){}
                panel.setText(modifiedString);
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