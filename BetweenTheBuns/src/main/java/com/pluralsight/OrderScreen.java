package com.pluralsight;

import com.pluralsight.model.Order;

import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner;
    private Order order;

    public OrderScreen() {
        scanner = new Scanner(System.in);
        order = new Order();
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\nOrder Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Exit");
            System.out.println("Please Select an Option: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                AddSandwich addSandwich = new AddSandwich(order);
                addSandwich.show();
            } else if (choice.equals("2")) {
                AddDrink addDrink = new AddDrink(order);
                addDrink.show();
            } else if (choice.equals("3")) {
                AddChips addChips = new AddChips(order);
                addChips.show();
            } else if (choice.equals("4")) {
                CheckOut checkOut = new CheckOut(order);
                checkOut.show();
                HomeScreen homeScreen = new HomeScreen();
                homeScreen.showHomeScreen();
                running = false;
            } else if (choice.equals("0")) {
                System.out.println("Your order has been canceled, Thank You for visiting Between the Buns!");
                running = false;
            } else {
                System.out.println("Oops, please try again.");
            }
        }
    }
}

