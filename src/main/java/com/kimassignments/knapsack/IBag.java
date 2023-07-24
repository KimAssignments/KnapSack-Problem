package com.kimassignments.knapsack;

import java.util.Collection;

interface IBag<T> {

    /**
     * @param item the item to add to the bag
     */
    void add(T item);

    /**
     * @param index the index of the item to remove
     * @return the item that was removed
     */
    T remove(int index);

    /**
     * @return an unmodifiable list of items in the bag
     */
    Collection<T> getItems();

    /**
     * @return the total weight of all items in the bag
     */
    double getWeight();

    /**
     * @return the total value of all items in the bag
     */
    double getValue();

    /**
     * @return true if the bag is full, false otherwise
     */
    boolean isFull();

    /**
     * @return true if the bag is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * @return the number of items in the bag
     */
    int size();

    /**
     * Removes all items from the bag
     * @return an unmodifiable list of removed items from the bag
     */
    Collection<T> clear();
}
