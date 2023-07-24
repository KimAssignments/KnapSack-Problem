package com.example.example;

import java.util.Scanner;

import com.kimassignments.knapsack.Item;
import com.kimassignments.knapsack.PriorityBag;
import com.kimassignments.knapsack.sorting.SortingType;

public class PriorityBagExample {
    private static Scanner scanner = new Scanner(System.in);
    private static PriorityBag bag;

    public static void main(String[] args) {
        System.out.print("\nEnter max weight in grams:");
        double maxWeightInGrams = Double.valueOf(scanner.nextLine());
        System.out.print("\nEnter sorting type (GREEDY, BRUTE_FORCE, MEMOIZATION, FULLY_POLYNOMIAL_TIME_APPROXIMATION, BRANCH_AND_BOUND, DYNAMIC_PROGRAMMING, RECURSIVE_APPROACH):");
        SortingType sortingType = SortingType.valueOf(scanner.nextLine());

        bag = new PriorityBag(maxWeightInGrams, sortingType);

        while (true) {
            System.out.print("\nEnter item name:");
            String name = scanner.nextLine();

            System.out.print("\nEnter item weight (gram):");
            double weight = Double.valueOf(scanner.nextLine());

            System.out.print("\nEnter item value:");
            double value = Double.valueOf(scanner.nextLine());

            cls();
            addItem(new Item(name, weight, value));
            printBagInfo();
            printItems();
        }
    }

    private static void printBagInfo() {
        System.out.printf(
            "\nBag info: %f max grams, %f grams, %f values\n",
            bag.getMaxWeightInGrams(),
            bag.getWeight(),
            bag.getValue()
        );
    }

    private static void printItems() {
        System.out.println("\nCurrent inventory:");
        for (Item item : bag.getItems()) {
            System.out.printf("%s, %f grams, %f values\n", item.getName(), item.getWeight(), item.getValue());
        }
    }

    private static void addItem(Item item) {
        bag.add(
            item,
            (removedItems) -> {
                System.out.println("\nThe following items had been removed from the bag:");
                removedItems.forEach(
                    (ri) -> {
                        System.out.printf("%s, %f grams, %f values\n", ri.getName(), ri.getWeight(), ri.getValue());
                    }
                );
            }
        );
    }

    private static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
