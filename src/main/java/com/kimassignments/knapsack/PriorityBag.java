package com.kimassignments.knapsack;

import java.util.List;
import java.util.function.Consumer;

import com.kimassignments.knapsack.sorting.SortResult;
import com.kimassignments.knapsack.sorting.Sorting;
import com.kimassignments.knapsack.sorting.SortingType;

public class PriorityBag extends Bag {
    private SortingType sortingType;

    public PriorityBag(double maxWeightInGrams, SortingType sortingType) {
        super(maxWeightInGrams);
        this.sortingType = sortingType;
    }

    /**
     * Adds an item to the bag, removing items if necessary.
     * <p>
     * <strong>WARNING: </strong>
     * This method will not reserve the removed items.
     * If you want to keep track of the removed items,
     * use {@link #add(Item, Consumer)}
     * </p>
     * @param item
     */
    @Override
    public synchronized void add(Item item) {
        add(item, removedItem -> {});
    }

    /**
     * Adds an item to the bag, removing items if necessary.
     * @param item
     * @param removedItems a consumer that accepts a list of removed items
     */
    public synchronized void add(Item item, Consumer<List<Item>> removedItems) {
        this.items.add(item);
        SortResult result = Sorting.sort(this.items, this.maxWeightInGrams, this.sortingType);
        this.items.clear();
        this.items.addAll(result.getIncluded());
        removedItems.accept(result.getExcluded());
    }

    /**
     * Adds a list of items to the bag, removing items if necessary.
     * <p>
     * <strong>WARNING: </strong>
     * This method will not reserve the removed items.
     * If you want to keep track of the removed items,
     * use {@link #add(List, Consumer)}
     * </p>
     * @param items
     */
    @Override
    public synchronized void add(List<Item> items) {
        add(items, removedItems -> {});
    }

    /**
     * Adds a list of items to the bag, removing items if necessary.
     * @param items
     * @param removedItems a consumer that accepts a list of removed items
     */
    public synchronized void add(List<Item> items, Consumer<List<Item>> removedItems) {
        this.items.addAll(items);
        SortResult result = Sorting.sort(this.items, this.maxWeightInGrams, this.sortingType);
        this.items.clear();
        this.items.addAll(result.getIncluded());
        removedItems.accept(result.getExcluded());
    }

    public PriorityBag setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
        return this;
    }
}
