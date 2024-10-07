package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                Intent intent = new Intent(ActivityFinishOrder.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }
        });
    }
}