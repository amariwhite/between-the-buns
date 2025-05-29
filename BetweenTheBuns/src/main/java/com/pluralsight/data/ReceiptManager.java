package com.pluralsight.data;

import com.pluralsight.model.Chip;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReceiptManager {
    public void saveReceipt(Order order) {


        StringBuilder receipt = new StringBuilder();

        receipt.append("Sandwiches:\n");
        ArrayList<Sandwich> sandwiches = order.getSandwiches();
        for (int i = 0; i < sandwiches.size(); i++) {
            Sandwich sandwich = sandwiches.get(i);
            receipt.append("Sandwich " + (i + 1) + ": Size: " + sandwich.getSize() + ", Bread: " + sandwich.getBreadType() + (sandwich.isToasted() ? ", Toasted" : "") + "\n");
            receipt.append("  Meats: " + sandwich.getMeats() + "\n");
            receipt.append("  Cheeses: " + sandwich.getCheeses() + "\n");
            receipt.append("  Toppings: " + sandwich.getRegularToppings() + "\n");
            receipt.append("  Sauces: " + sandwich.getSauces() + "\n");
        }

        receipt.append("\nDrinks:\n");
        ArrayList<Drink> drinks = order.getDrinks();
        for (int i = 0; i < drinks.size(); i++) {
            Drink drink = drinks.get(i);
            receipt.append("Drink " + (i + 1) + ": Size: " + drink.getSize() + ", Flavor: " + drink.getFlavor() + "\n");
        }

        receipt.append("\nChips:\n");
        ArrayList<Chip> chips = order.getChips();
        for (int i = 0; i < chips.size(); i++) {
            Chip chip = chips.get(i);
            receipt.append("Chips " + (i + 1) + ": " + chip.getType() + "\n");
        }

        double total = order.calculateTotal();
        receipt.append("\nTotal: $" + String.format("%.2f", total) + "\n");

        try {
            Files.createDirectories(Paths.get("receipts.txt"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipts/" + LocalDateTime.now().format(formatter) + ".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(receipt.toString());
            writer.close();

            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}