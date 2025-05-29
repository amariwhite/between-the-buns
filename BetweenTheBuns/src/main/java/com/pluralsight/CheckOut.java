// Original CheckOut class before safety fix for extra meat and cheese indexes

package com.pluralsight;

import com.pluralsight.model.*;
import com.pluralsight.data.ReceiptManager;
import java.util.Scanner;
import java.util.ArrayList;

public class CheckOut {
    private Order order;
    private Scanner scanner;

    public CheckOut(Order order) {
        this.order = order;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        System.out.println("\n-- Checkout --");

        double total = order.calculateTotal();
        System.out.println("\nOrder Summary:");
        ArrayList<Sandwich> sandwiches = order.getSandwiches();
        for (int i = 0; i < sandwiches.size(); i++) {
            Sandwich s = sandwiches.get(i);
            System.out.println("Sandwich " + (i + 1) + ": Size: " + s.getSize() + ", Bread: " + s.getBreadType() + (s.isToasted() ? ", Toasted" : ""));
            ArrayList<String> meats = s.getMeats();
            ArrayList<String> cheeses = s.getCheeses();
            for (int j = 0; j < meats.size(); j++) {
                String meat = meats.get(j);
                boolean isExtra = s.getExtraMeat().get(j);
                System.out.println("  Meat: " + meat + (isExtra ? " (extra)" : ""));
            }
            for (int j = 0; j < cheeses.size(); j++) {
                String cheese = cheeses.get(j);
                boolean isExtra = s.getExtraCheese().get(j);
                System.out.println("  Cheese: " + cheese + (isExtra ? " (extra)" : ""));
            }
            System.out.println("  Toppings: " + s.getRegularToppings());
            System.out.println("  Sauces: " + s.getSauces());
        }

        ArrayList<Drink> drinks = order.getDrinks();
        for (int i = 0; i < drinks.size(); i++) {
            Drink d = drinks.get(i);
            System.out.println("Drink " + (i + 1) + ": Size: " + d.getSize() + ", Flavor: " + d.getFlavor());
        }

        ArrayList<Chip> chips = order.getChips();
        for (int i = 0; i < chips.size(); i++) {
            Chip chip = chips.get(i);
            System.out.println("Chips " + (i + 1) + ": " + chip.getType());
        }

        System.out.println("\nTotal: $" + String.format("%.2f", total));

        System.out.println("\n1) Confirm Order");
        System.out.println("0) Cancel Order");
        System.out.print("Select an option: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            ReceiptManager receiptManager = new ReceiptManager();
            receiptManager.saveReceipt(order);
            System.out.println("Order confirmed. Thank you!");
        } else {
            System.out.println("Order cancelled. Returning to home screen.");
        }
    }
}
