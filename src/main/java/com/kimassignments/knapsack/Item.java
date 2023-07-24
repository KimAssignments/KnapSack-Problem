package com.kimassignments.knapsack;

import java.io.Serializable;

public class Item implements Serializable {
    private final long itemID;
    private final String name;
    private final double weightInGrams;
    private final double values;

    public Item(String name, double weightInGrams, double values) {
        this.itemID = System.currentTimeMillis();
        this.name = name;
        this.weightInGrams = weightInGrams;
        this.values = values;
    }

    public String getName() {
        return this.name;
    }

    public long getItemID() {
        return this.itemID;
    }

    public double getWeight() {
        return this.weightInGrams;
    }

    public double getWeightInKilograms() {
        return this.weightInGrams / 1000.0D;
    }

    public double getValue() {
        return this.values;
    }
}
