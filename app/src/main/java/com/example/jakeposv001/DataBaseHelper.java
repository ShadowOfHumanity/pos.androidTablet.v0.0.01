package com.example.jakeposv001;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.util.ArrayList;

import java.text.SimpleDateFormat; // For formatting date
import java.util.Calendar; // For working with dates and times


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Orders.db";
    private static final int DATABASE_VERSION = 1;

    // Table and columns
    private static final String TABLE_ORDERS = "orders";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_DATE = "order_date";

    // Constructor
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the orders table
        String createTable = "CREATE TABLE " + TABLE_ORDERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ITEM + " TEXT, " +
                COLUMN_PRICE + " REAL, " +
                COLUMN_DATE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        // Recreate table
        onCreate(db);
    }

    // Add order to the database
    public void insertOrder(ArrayList<String> items, ArrayList<String> prices) {
        SQLiteDatabase db = this.getWritableDatabase();
        long currentTimeMillis = System.currentTimeMillis();
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(currentTimeMillis));

        for (int i = 0; i < items.size(); i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_ITEM, items.get(i));
            values.put(COLUMN_PRICE, Double.parseDouble(prices.get(i)));
            values.put(COLUMN_DATE, date);
            db.insert(TABLE_ORDERS, null, values);
        }
    }

    // Get the best-selling product
    @SuppressLint("Range")
    public String getBestSellingProduct() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_ITEM + ", COUNT(" + COLUMN_ITEM + ") AS count FROM " + TABLE_ORDERS +
                " GROUP BY " + COLUMN_ITEM + " ORDER BY count DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);
        String bestSellingProduct = null; // Initialize variable to store the best selling product
        if (cursor.moveToFirst()) {
            bestSellingProduct = cursor.getString(cursor.getColumnIndex(COLUMN_ITEM));
        }
        cursor.close();
        return bestSellingProduct; // Return best selling product
    }

    // Get total earnings for a day
    public double getTotalEarnings(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + COLUMN_PRICE + ") AS total FROM " + TABLE_ORDERS +
                " WHERE " + COLUMN_DATE + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{date});
        double total = 0.00;
        if (cursor.moveToFirst()) {
            int totalColumnIndex = cursor.getColumnIndex("total"); // Get index of "total" column
            if (totalColumnIndex != -1) { // Check if column index is valid
                total = cursor.getDouble(totalColumnIndex); // Retrieve total earnings
            }
        }
        cursor.close();
        return total; // Return total earnings for the specified date
    }

    // Get total earnings for all time
    public double getTotalEarningsForAllDays() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + COLUMN_PRICE + ") AS total FROM " + TABLE_ORDERS;
        Cursor cursor = db.rawQuery(query, null);
        double total = 0.00;
        if (cursor.moveToFirst()) {
            int totalColumnIndex = cursor.getColumnIndex("total"); // Get index of "total" column
            if (totalColumnIndex != -1) { // Check if column index is valid
                total = cursor.getDouble(totalColumnIndex); // Retrieve total earnings
            }
        }
        cursor.close();
        return total; // Return total earnings for all days
    }
    // In DataBaseHelper class
    @SuppressLint("Range")
    public ArrayList<String> getUniqueOrderDates() {
        ArrayList<String> uniqueDates = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT DISTINCT " + COLUMN_DATE + " FROM " + TABLE_ORDERS;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                uniqueDates.add(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return uniqueDates;
    }

    public double getTotalEarningsForWeek() {
        SQLiteDatabase db = this.getReadableDatabase();
        double total = 0.00;

        // Get the start and end dates of the current week
        Calendar calendar = Calendar.getInstance();

        // Set to the first day of the week (Monday)
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

        // Set to the last day of the week (Sunday)
        calendar.add(Calendar.DAY_OF_WEEK, 6); // Move to Sunday
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

        String query = "SELECT SUM(" + COLUMN_PRICE + ") AS total FROM " + TABLE_ORDERS +
                " WHERE " + COLUMN_DATE + " BETWEEN ? AND ?";
        Cursor cursor = db.rawQuery(query, new String[]{startDate, endDate});

        if (cursor.moveToFirst()) {
            int totalColumnIndex = cursor.getColumnIndex("total");
            if (totalColumnIndex != -1) {
                total = cursor.getDouble(totalColumnIndex);
            }
        }
        cursor.close();
        return total; // Return total earnings for the week
    }
//    public void deleteAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
//        // Add other DROP TABLE statements for any additional tables you have
//        // e.g., db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
//        // ...
//        onCreate(db); // Recreate the tables after dropping
//        db.close();
//    }


}
