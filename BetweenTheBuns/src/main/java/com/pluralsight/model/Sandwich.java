package com.pluralsight.model;

import java.util.ArrayList;

public class Sandwich {
    private String size;
    private String breadType;
    private boolean toasted;
    private ArrayList<String> meats;
    private ArrayList<Boolean> extraMeat;
    private ArrayList<String> cheeses;
    private ArrayList<Boolean> extraCheese;
    private ArrayList<String> regularToppings;
    private ArrayList<String> sauces;

    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        meats = new ArrayList<String>();
        extraMeat = new ArrayList<Boolean>();
        cheeses = new ArrayList<String>();
        extraCheese = new ArrayList<Boolean>();
        regularToppings = new ArrayList<String>();
        sauces = new ArrayList<String>();
    }

    public ArrayList<Boolean> getExtraMeat() {
        return extraMeat;
    }

    public ArrayList<Boolean> getExtraCheese() {
        return extraCheese;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getRegularToppings() {
        return regularToppings;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void addMeat(String meat, boolean isExtra) {
        meats.add(meat);
        extraMeat.add(isExtra);
    }

    public void addCheese(String cheese, boolean isExtra) {
        cheeses.add(cheese);
        extraCheese.add(isExtra);
    }

    public void addTopping(String topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public double calculateCost() {
        double price = 0;

        if (size.equals("4")) {
            price += 5.50;
            for (int i = 0; i < meats.size(); i++) {
                if (extraMeat.get(i)) price += 0.50;
                price += 1.00;
            }
            for (int i = 0; i < cheeses.size(); i++) {
                if (extraCheese.get(i)) price += 0.30;
                price += 0.75;
            }
        }else if (size.equals("8")) {
            price += 7.00;
            for (int i = 0; i < meats.size(); i++) {
                if (extraMeat.get(i)) price += 1.00;
                price += 2.00;
            }
            for (int i = 0; i < cheeses.size(); i++) {
                if (extraCheese.get(i)) price += 0.60;
                price += 1.50;
            }
        }else if (size.equals("12")) {
            price += 8.50;
            for (int i = 0; i < meats.size(); i++) {
                if (extraMeat.get(i)) price += 1.50;
                price += 3.00;
            }
            for (int i = 0; i < cheeses.size(); i++) {
                if (extraCheese.get(i)) price += 0.90;
                price += 2.25;
            }
        }
        return price;
    }
}
