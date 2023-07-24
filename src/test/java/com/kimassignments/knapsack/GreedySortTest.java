package com.kimassignments.knapsack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kimassignments.knapsack.sorting.SortResult;
import com.kimassignments.knapsack.sorting.Sorting;
import com.kimassignments.knapsack.sorting.SortingType;

public class GreedySortTest {

    @Test
    public void testGreedySort() {
        // Create a list of items to sort
        List<Item> items = new ArrayList<>();
        items.add(new Item("1 $1 coin", 100, 10));
        items.add(new Item("1 $5 coin", 500, 50));
        items.add(new Item("1 $2 coin", 200, 20));
        items.add(new Item("2 $1 coin", 100, 10));
        items.add(new Item("2 $2 coin", 200, 20));
        items.add(new Item("3 $1 coin", 100, 10));
        items.add(new Item("4 $1 coin", 100, 10));

        // Sort the items using the greedySort method
        SortResult result = Sorting.sort(items, 300, SortingType.GREEDY);

        // Check that the included items are sorted by value
        List<Item> included = result.getIncluded();
        assertEquals(2, included.size());
        assertEquals("1 $2 coin", included.get(0).getName());
        assertEquals("1 $1 coin", included.get(1).getName());

        // Check that the excluded items are sorted by weight
        List<Item> excluded = result.getExcluded();
        assertEquals(5, excluded.size());
        assertEquals("1 $5 coin", excluded.get(0).getName());
        assertEquals("2 $2 coin", excluded.get(1).getName());
        assertEquals("2 $1 coin", excluded.get(2).getName());
        assertEquals("3 $1 coin", excluded.get(3).getName());
        assertEquals("4 $1 coin", excluded.get(4).getName());
    }

    @Test
    public void testGreedySortEmptyList() {
        // Create an empty list of items to sort
        List<Item> items = new ArrayList<>();

        // Sort the items using the greedySort method
        SortResult result = Sorting.sort(items, 300, SortingType.GREEDY);

        // Check that the included and excluded lists are empty
        List<Item> included = result.getIncluded();
        assertEquals(0, included.size());
        List<Item> excluded = result.getExcluded();
        assertEquals(0, excluded.size());
    }

    @Test
    public void testGreedySortAllExcluded() {
        // Create a list of items that are all excluded
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 100, 50));
        items.add(new Item("Item 2", 200, 75));
        items.add(new Item("Item 3", 150, 100));
        items.add(new Item("Item 4", 60, 25));

        // Sort the items using the greedySort method with a low max weight
        SortResult result = Sorting.sort(items, 50, SortingType.GREEDY);

        // Check that all items are excluded
        List<Item> included = result.getIncluded();
        assertEquals(0, included.size());
        List<Item> excluded = result.getExcluded();
        assertEquals(4, excluded.size());
    }

    @Test
    public void testGreedySortAllIncluded() {
        // Create a list of items that are all included
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 100, 50));
        items.add(new Item("Item 2", 200, 75));
        items.add(new Item("Item 3", 150, 100));
        items.add(new Item("Item 4", 50, 25));

        // Sort the items using the greedySort method with a high max weight
        SortResult result = Sorting.sort(items, 500, SortingType.GREEDY);

        // Check that all items are included
        List<Item> included = result.getIncluded();
        assertEquals(4, included.size());
        List<Item> excluded = result.getExcluded();
        assertEquals(0, excluded.size());
    }
}
