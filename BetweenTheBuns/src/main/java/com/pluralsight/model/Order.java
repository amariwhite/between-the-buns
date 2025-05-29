package com.pluralsight.model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chip> chips;

    public Order() {
        sandwiches = new ArrayList<Sandwich>();
        drinks = new ArrayList<Drink>();
        chips = new ArrayList<Chip>();
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }
    public void addChip(Chip chip){
        chips.add(chip);
    }
    public double calculateTotal() {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculateCost();
        }

        for (Drink drink : drinks) {
            if (drink.getSize().equalsIgnoreCase("small")) {
                total += 2.00;
            } else if (drink.getSize().equalsIgnoreCase("medium")) {
                total += 2.50;
            } else if (drink.getSize().equalsIgnoreCase("large")) {
                total += 3.00;
            }
        }

        total += chips.size() * 1.50;

        return total;
    }
}

