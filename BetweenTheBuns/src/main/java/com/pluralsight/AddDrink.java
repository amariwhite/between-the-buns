package com.pluralsight;

import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddDrink {
    private Scanner scanner;
    private Order order;

    public AddDrink(Order order) {
        this.order = order;
        scanner = new Scanner(System.in);
    }
    //add drink logic
   public void show(){
       System.out.println("\n-- Add a Drink --");
       System.out.print("Choose drink size [Small  Medium  Large]: ");
       String size = scanner.nextLine();

       System.out.print("Enter flavor: ");
       String flavor = scanner.nextLine();

       Drink drink = new Drink(size, flavor);
       order.addDrink(drink);
       System.out.println("Drink added to order.");
    }
}
