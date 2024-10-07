package com.example.jakeposv001;

import android.widget.TextView;

import java.util.ArrayList;

public class InsideOrder {

    // Step 1: Create a private static instance of this class
    private static InsideOrder instance;

    private ArrayList<String> Items;
    private ArrayList<String> Prices;
    private int extraProdCount;

    // Step 2: Make the constructor private to prevent external instantiation
    private InsideOrder() {
        Items = new ArrayList<>();
        Prices = new ArrayList<>();
        extraProdCount = 0;
    }

    // Step 3: Provide a public method to get the single instance
    public static InsideOrder getInstance() {
        if (instance == null) {
            instance = new InsideOrder();
        }
        return instance;
    }

    // Other methods to add data, retrieve items, prices, and clear the order
    public void addData(String data, String price) {
        Items.add(data);
        Prices.add(price);
    }

    public ArrayList<String> getItems() {
        return Items;
    }

    public ArrayList<String> getPrices() {
        return Prices;
    }

    public void addExtraProd(String InText){
        String Result = String.format("%.2f", evaluateEquation(InText)); //(String.valueOf(evaluateEquation(InText)));
        addData("Product" +extraProdCount, Result);
        extraProdCount++;
    }

    public void clearOrder() {
        Items.clear();
        Prices.clear();
        extraProdCount = 0;
    }

    public void updateAllTotals(TextView SidePanel){
        double totalPrice = 0.00;
        String text = "";
        for (String price : Prices){
            totalPrice+=Double.parseDouble(price);
        }

        for (int i = 0; i<Prices.size();i++){
            text += Items.get(i) + " - €"+ Prices.get(i) + "\n";
        }


        SidePanel.setText("TOTAL: €" + String.format("%.2f", totalPrice) +"\n"+text);
    }


























    public static double evaluateEquation(String equation) {
        // Remove spaces from the equation
        equation = equation.replaceAll(" ", "");

        // Check if the input is a number
        if (equation.matches("-?\\d+(\\.\\d+)?")) { // Regular expression to check for a number
            return Double.parseDouble(equation);
        }

        // Extract operator (it assumes there's only one operator in the equation)
        String operator = equation.replaceAll("[0-9.]", ""); // Keep only the operator
        String[] tokens = equation.split("[+*]"); // Split the equation by operator

        // Validate that we have exactly two tokens (operands)
        if (tokens.length != 2) {
            throw new IllegalArgumentException("Invalid equation format. Expected format: 'operand1 operator operand2'.");
        }

        try {
            // Parse operands
            double operand1 = Double.parseDouble(tokens[0]);
            double operand2 = Double.parseDouble(tokens[1]);

            // Perform the operation based on the operator
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "*":
                    return operand1 * operand2;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid number format: " + ex.getMessage());
        }
    }


}
