package com.pluralsight;

import com.pluralsight.model.Chip;
import com.pluralsight.model.Order;

import java.util.Scanner;

public class AddChips {
    private Scanner scanner;
    private Order order;

    public AddChips(Order order){
        this.order = order;
        scanner = new Scanner(System.in);
    }

    public void show(){
        //add chips logic
        System.out.println("\n-- Add Chips --");
        System.out.print("Enter chip type: ");
        String chipType = scanner.nextLine();

        Chip chip = new Chip(chipType);
        order.addChip(chip);
        System.out.println("Chips added to order.");
    }
}
