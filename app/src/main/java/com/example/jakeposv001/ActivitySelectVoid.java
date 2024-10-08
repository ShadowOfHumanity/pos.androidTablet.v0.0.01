package com.example.jakeposv001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ActivitySelectVoid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_void);

        // Button to go back
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Go back to the previous activity
            }
        });


        InsideOrder insideOrder = InsideOrder.getInstance();

        // Update the side panel texts whenever the activity is resumed
        insideOrder.updateAllTotals(findViewById(R.id.text_total));

        // Call the method to generate buttons initially
        generateButtons();
    }

    @Override
    protected void onResume() {
        super.onResume();
        InsideOrder insideOrder = InsideOrder.getInstance();
        // Update the side panel texts whenever the activity is resumed
        insideOrder.updateAllTotals(findViewById(R.id.text_total));
        // Call the method to regenerate or update buttons when the activity resumes
        generateButtons();
    }

    // Method to dynamically generate buttons
        private void generateButtons() {
            // Reference to GridLayout (for dynamically adding buttons)
            GridLayout buttonGrid = findViewById(R.id.grid_layout_buttons);

            // Clear any previously added buttons to avoid duplicates
            buttonGrid.removeAllViews();

            InsideOrder insideOrder = InsideOrder.getInstance();
            try {
                // Loop through the items and add buttons dynamically
                for (int i = 0; i<insideOrder.getItems().size();i++) {
                    Button button = new Button(this);
                    button.setText(insideOrder.getItems().get(i) + " - " + insideOrder.getPrices().get(i) );
                    button.setBackgroundColor(getResources().getColor(R.color.teal_200));  // Example background color
                    button.setTextColor(getResources().getColor(R.color.white));  // Example text color
                    button.setTextSize(18);  // Example text size

                    // Set layout parameters for button
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 0;  // Width will be controlled by the weight
                    params.height = GridLayout.LayoutParams.WRAP_CONTENT;  // Height will wrap the content
                    params.setMargins(8, 8, 8, 8);  // Example margins
                    params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f); // Set width to 1 weight
                    button.setLayoutParams(params);

                    // Add click listener (optional)
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Extract only the product name from the button text
                            String buttonText = (String) button.getText();
                            String productName = buttonText.split(" - ")[0]; // Get the item name before " - "

                            // Call the deleteProduct method with the correct product name
                            insideOrder.deleteProduct(productName);

                            // Regenerate buttons to reflect the changes
                            generateButtons();

                            // Update totals after deletion
                            insideOrder.updateAllTotals(findViewById(R.id.text_total));
                        }
                    });

                // Add the button to the GridLayout
                buttonGrid.addView(button);
            }
        } catch (Exception ignored){}
    }
}
