package com.kimassignments.knapsack.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

import com.kimassignments.knapsack.Item;

public class Sorting {
    /**
     * Sorts the items based on the sorting type
     * @param items
     * @param maxWeightInGrams
     * @param sortingType
     * @return SortResult object containing the included and excluded items
     */
    public static SortResult sort(List<? extends Item> items, double maxWeightInGrams, SortingType sortingType) {
        switch (sortingType) {
            case GREEDY:
                return greedySort(items, maxWeightInGrams);
            case BRUTE_FORCE:
                return bruteForceSort(items, maxWeightInGrams);
            case MEMOIZATION:
                return memoizationSort(items, maxWeightInGrams);
            case FULLY_POLYNOMIAL_TIME_APPROXIMATION:
                return fullyPolynomialTimeApproximationSort(items, maxWeightInGrams);
            case BRANCH_AND_BOUND:
                return branchAndBoundSort(items, maxWeightInGrams);
            case DYNAMIC_PROGRAMMING:
                return dynamicProgrammingSort(items, maxWeightInGrams);
            case RECURSIVE_APPROACH:
                return recursiveApproachSort(items, maxWeightInGrams);

            default:
                throw new IllegalArgumentException("Invalid sorting type");
        }
    }

    private static SortResult greedySort(List<? extends Item> items, double maxWeightInGrams) {
        final List<Item> included = new ArrayList<>();
        final List<Item> excluded = new ArrayList<>();

        items.stream()
            .sorted(Comparator.comparingDouble((ToDoubleFunction<Item>) Item::getValue).reversed())
            .forEachOrdered(
                (item) -> {
                    if (item.getWeight() + included.stream().mapToDouble(Item::getWeight).sum() > maxWeightInGrams) {
                        excluded.add(item);
                        return;
                    }

                    included.add(item);
                }
            );

        return new SortResult(included, excluded, SortingType.GREEDY);
    }

    private static SortResult bruteForceSort(List<? extends Item> items, double maxWeightInGrams) {
        final List<Item> included = new ArrayList<>();
        final List<Item> excluded = new ArrayList<>();

        items.stream()
            .forEachOrdered(
                (item) -> {
                    if (item.getWeight() + included.stream().mapToDouble(Item::getWeight).sum() > maxWeightInGrams) {
                        excluded.add(item);
                        return;
                    }

                    included.add(item);
                }
            );

        return new SortResult(included, excluded, SortingType.BRUTE_FORCE);
    }

    private static SortResult memoizationSort(List<? extends Item> items, double maxWeightInGrams) {
        final List<Item> included = new ArrayList<>();
        final List<Item> excluded = new ArrayList<>();
        final List<Double> excludedWeights = new ArrayList<>();

        items.stream()
            .forEachOrdered(
                (item) -> {
                    if (
                        excludedWeights.contains(item.getWeight()) || (
                            !excludedWeights.isEmpty() &&
                            excludedWeights.stream().sorted(Comparator.reverseOrder()).toArray(Double[]::new)[0] <= item.getWeight()
                        )
                    ) {
                        excluded.add(item);
                        return;
                    }
                    if (item.getWeight() + included.stream().mapToDouble(Item::getWeight).sum() > maxWeightInGrams) {
                        excludedWeights.add(item.getWeight());
                        excluded.add(item);
                        return;
                    }

                    included.add(item);
                }
            );

        return new SortResult(included, excluded, SortingType.MEMOIZATION);
    }

    private static SortResult fullyPolynomialTimeApproximationSort(List<? extends Item> items, double maxWeightInGrams) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static SortResult branchAndBoundSort(List<? extends Item> items, double maxWeightInGrams) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static SortResult dynamicProgrammingSort(List<? extends Item> items, double maxWeightInGrams) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private static SortResult recursiveApproachSort(List<? extends Item> items, double maxWeightInGrams) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
