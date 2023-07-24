package com.kimassignments.knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kimassignments.knapsack.sorting.SortResult;
import com.kimassignments.knapsack.sorting.Sorting;
import com.kimassignments.knapsack.sorting.SortingType;

public class BruteForceSortTest {

    @Test
    public void testBruteForceSortWithEmptyList() {
        List<Item> items = new ArrayList<>();

        double maxWeightInGrams = 100.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.BRUTE_FORCE);

        assertTrue(result.getIncluded().isEmpty());
        assertTrue(result.getExcluded().isEmpty());
        assertEquals(SortingType.BRUTE_FORCE, result.getSortingType());
    }

    @Test
    public void testBruteForceSortWithSingleItem() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 50, 100));

        double maxWeightInGrams = 100.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.BRUTE_FORCE);

        assertEquals(1, result.getIncluded().size());
        assertTrue(result.getExcluded().isEmpty());
    }

    @Test
    public void testBruteForceSortWithMultipleItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 50, 100));
        items.add(new Item("Item 2", 75, 200));
        items.add(new Item("Item 3", 100, 150));

        double maxWeightInGrams = 200.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.BRUTE_FORCE);

        assertEquals(2, result.getIncluded().size());
        assertEquals("Item 1", result.getIncluded().get(0).getName());
        assertEquals("Item 2", result.getIncluded().get(1).getName());

        assertEquals(1, result.getExcluded().size());
        assertEquals("Item 3", result.getExcluded().get(0).getName());
    }

    @Test
    public void testBruteForceSortWithAllItemsExcluded() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Item 1", 60, 100));
        items.add(new Item("Item 2", 75, 200));
        items.add(new Item("Item 3", 100, 150));

        double maxWeightInGrams = 50.0;

        SortResult result = Sorting.sort(items, maxWeightInGrams, SortingType.BRUTE_FORCE);

        assertTrue(result.getIncluded().isEmpty());
        assertEquals(3, result.getExcluded().size());
    }
}
