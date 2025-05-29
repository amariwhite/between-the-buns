package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen() {
        scanner = new Scanner(System.in);

    }

    public void showHomeScreen() {
        while (true) {
            System.out.println("==============================");
            System.out.println("Welcome to Between the Buns!");
            System.out.println("==============================");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Please Select an Option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                OrderScreen orderScreen = new OrderScreen();
                orderScreen.show();
                break;
            } else if (choice.equals("0")) {
                System.out.println("Thank You for visiting Between the Buns!");

            } else {
                System.out.println("Oops, please try again.");
            }
        }
    }
}
