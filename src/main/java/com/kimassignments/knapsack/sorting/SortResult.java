package com.kimassignments.knapsack.sorting;

import java.util.List;

import com.kimassignments.knapsack.Item;

public class SortResult {
    private final List<Item> included;
    private final List<Item> excluded;
    private final SortingType sortingType;

    SortResult(List<Item> included, List<Item> excluded, SortingType sortingType) {
        this.included = included;
        this.excluded = excluded;
        this.sortingType = sortingType;
    }

    public List<Item> getIncluded() {
        return this.included;
    }

    public List<Item> getExcluded() {
        return this.excluded;
    }

    public SortingType getSortingType() {
        return this.sortingType;
    }
}
