package com.pluralsight;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;

import java.util.Scanner;

public class AddSandwich {
    private Scanner scanner;
    private Order order;

    public AddSandwich(Order order) {
        this.order = order;
        scanner = new Scanner(System.in);
    }

    //custom sandwich logic
    public void show() {
        System.out.println("\n-- Add a Sandwich --");
        System.out.print("Choose size [4\"/8\"/12\"]: ");
        String size = scanner.nextLine();

        System.out.print("Choose bread type [White  Wheat  Rye  Wrap]: ");
        String bread = scanner.nextLine();

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");


        Sandwich sandwich = new Sandwich(size, bread, toasted);

        System.out.println("Add meats [Steak  Ham  Salami  Roast Beef  Chicken  Bacon] \n(type 'done' to finish):");
        while (true) {
            System.out.print("Meat: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("done"))break;

            System.out.println("Want extra meat? (yes/no): ");
            boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addMeat(choice, extraMeat);
//
        }

        System.out.println("Add cheeses [American  Provolone  Cheddar  Swiss] \n(type 'done' to finish)");
        while (true) {
            System.out.print("Cheese: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("done")) break;

            System.out.println("Want extra cheese? (yes/no): ");
            boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.addCheese(choice, extraCheese);
        }

        System.out.println("Add regular toppings [Lettuce Peppers Onions Tomatoes Jalapenos Cucumbers Pickles Guac Mushrooms] \n(type 'done' to finish):");
        while (true) {
            System.out.print("Topping: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("done")) break;
            sandwich.addTopping(choice);
        }

        System.out.println("Add sauces [Mayo  Mustard  Ketchup  Ranch  Thousand Island  Vinaigrette] \n(type 'done' to finish):");
        while (true) {
            System.out.print("Sauce: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("done")) break;
            sandwich.addSauce(choice);
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");
    }
}
