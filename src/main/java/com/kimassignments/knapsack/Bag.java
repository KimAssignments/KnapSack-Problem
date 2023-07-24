package com.kimassignments.knapsack;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bag implements IBag<Item>, Serializable, Cloneable {
    protected final List<Item> items;
    protected final double maxWeightInGrams;

    Bag(Bag bag) {
        this(bag.maxWeightInGrams, new LinkedList<>(bag.items));
    }

    Bag(double maxWeightInGrams, List<Item> items) {
        this.items = items;
        this.maxWeightInGrams = maxWeightInGrams;
    }

    public Bag(double maxWeightInGrams) {
        this.items = new LinkedList<>();
        this.maxWeightInGrams = maxWeightInGrams;
    }

    /**
     * @return a shallow copy of this Bag instance
     */
    public Bag clone() {
        Bag bag = new Bag(this.maxWeightInGrams, new LinkedList<>(this.items));
        return bag;
    }

    /**
     * @return a Bag instance that is unmodifiable
     */
    public UnmodifiableBag unmodifiable() {
        return new UnmodifiableBag(this);
    }

    /**
     * @return a Bag instance that has unlimited capacity
     */
    public UnlimitedBag unlimited() {
        return new UnlimitedBag();
    }

    public void add(Item item) {
        if (isFull())
            throw new IllegalStateException("Bag is full");
        if (item.getWeight() + getWeight() > this.maxWeightInGrams)
            throw new IllegalArgumentException("Item is too heavy");

        this.items.add(item);
    }

    public void add(List<Item> items) {
        if (isFull())
            throw new IllegalStateException("Bag is full");

        double totalWeight = items.stream()
            .mapToDouble(item -> item.getWeight())
            .sum();

        if (totalWeight + getWeight() > this.maxWeightInGrams)
            throw new IllegalArgumentException("Items are too heavy");

        this.items.addAll(items);
    }

    public Item remove(int index) {
        if (isEmpty())
            throw new IllegalStateException("Bag is empty");
        return this.items.remove(index);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public double getWeight() {
        return this.items
            .stream()
            .mapToDouble(item -> item.getWeight())
            .sum();
    }

    public double getValue() {
        return this.items
            .stream()
            .mapToDouble(item -> item.getValue())
            .sum();
    }

    public boolean isFull() {
        return (getWeight() >= this.maxWeightInGrams);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public int size() {
        return this.items.size();
    }

    public List<Item> clear() {
        List<Item> items = Collections.unmodifiableList(this.items);
        this.items.clear();
        return items;
    }

    /**
     * @return the maximum weight of the bag
     */
    public double getMaxWeightInGrams() {
        return this.maxWeightInGrams;
    }
}
