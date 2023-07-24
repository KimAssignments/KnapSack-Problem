package com.kimassignments.knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kimassignments.knapsack.sorting.SortResult;
import com.kimassignments.knapsack.sorting.Sorting;
import com.kimassignments.knapsack.sorting.SortingType;

public class MemoizationSortTest {

    @Test
    public void testMemoizationSortWithEmptyList() {
        List<Item> items = new ArrayList<>();

        double maxWeightInGrams = 100.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.MEMOIZATION);

        assertTrue(result.getIncluded().isEmpty());
        assertTrue(result.getExcluded().isEmpty());
        assertEquals(SortingType.MEMOIZATION, result.getSortingType());
    }

    @Test
    public void testMemoizationSortWithSingleItem() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Item 1", 50, 100));
        double maxWeightInGrams = 100.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.MEMOIZATION);

        assertEquals(1, result.getIncluded().size());
        assertTrue(result.getExcluded().isEmpty());
    }

    @Test
    public void testMemoizationSortWithMultipleItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Item 1", 50, 100));
        items.add(new Item("Item 2", 75, 200));
        items.add(new Item("Item 3", 50, 200));
        items.add(new Item("Item 4", 75, 200));
        items.add(new Item("Item 5", 50, 150));
        items.add(new Item("Item 6", 70, 150));
        items.add(new Item("Item 7", 15, 150));

        double maxWeightInGrams = 200.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.MEMOIZATION);

        assertEquals(4, result.getIncluded().size());
        assertEquals(3, result.getExcluded().size());
    }

    @Test
    public void testMemoizationSortWithAllItemsExcluded() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Item 1", 60, 100));
        items.add(new Item("Item 2", 60, 200));
        items.add(new Item("Item 3", 100, 150));
        double maxWeightInGrams = 50.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.MEMOIZATION);

        assertTrue(result.getIncluded().isEmpty());
        assertEquals(3, result.getExcluded().size());
    }
}
