package com.example.jakeposv001;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ActivityShowStatistics extends AppCompatActivity {

    private ListView statisticsListView;
    private TextView selectedDateTextView, totalEarnedTextView, allTimeBestSellingProductTextView;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_statistics);

        // Initialize DataBaseHelper
        dataBaseHelper = new DataBaseHelper(this);

        // Initialize Views
        statisticsListView = findViewById(R.id.statisticsListView);
        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        totalEarnedTextView = findViewById(R.id.totalEarnedTextView);
        allTimeBestSellingProductTextView = findViewById(R.id.allTimeBestSellingProductTextView); // Ensure this TextView is added in XML

        TextView weeklyEarningsTextView = findViewById(R.id.EarnedThisWeek);
        double weeklyEarnings = dataBaseHelper.getTotalEarningsForWeek(); // Get total earnings for the week
        weeklyEarningsTextView.setText("Total Earnings This Week: €" + String.format("%.2f", weeklyEarnings)); // Display it

        // Load and display all unique dates from the database
        ArrayList<String> uniqueDates = getUniqueDates();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, uniqueDates);
        statisticsListView.setAdapter(adapter);

        // Get the all-time best-selling product and display it
        displayAllTimeBestSellingProduct();
        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to ActivityMain
                Intent intent = new Intent(ActivityShowStatistics.this, ActivityMain.class);
                startActivity(intent);
                finish(); // Optional: finish this activity to remove it from the back stack
            }

        });
        // Set an item click listener to handle date clicks
        statisticsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDate = uniqueDates.get(position);
                displayStatisticsForDate(selectedDate);
            }
        });
    }

    // Display the all-time best-selling product
    private void displayAllTimeBestSellingProduct() {
        String allTimeBestSellingProduct = dataBaseHelper.getBestSellingProduct(); // Fetch the all-time best-selling product
        allTimeBestSellingProductTextView.setText("ALL TIME MOST BOUGHT PRODUCT: " + (allTimeBestSellingProduct != null ? allTimeBestSellingProduct : "None"));
    }

    // Fetch unique dates from the database
    private ArrayList<String> getUniqueDates() {
        return dataBaseHelper.getUniqueOrderDates(); // Call the method to get unique dates from the database
    }

    // Display statistics for the selected date
    private void displayStatisticsForDate(String date) {
        double totalEarned = dataBaseHelper.getTotalEarnings(date); // Get total earnings for the selected date
        selectedDateTextView.setText("Date: " + date);
        totalEarnedTextView.setText("Total Earned: €" + String.format("%.2f", totalEarned));

    }

    protected void onResume() {
        super.onResume();

        dataBaseHelper = new DataBaseHelper(this);

        TextView weeklyEarningsTextView = findViewById(R.id.EarnedThisWeek);
        double weeklyEarnings = dataBaseHelper.getTotalEarningsForWeek(); // Get total earnings for the week
        weeklyEarningsTextView.setText("Total Earnings This Week: €" + String.format("%.2f", weeklyEarnings)); // Display it

    }
}
