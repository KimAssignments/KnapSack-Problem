package com.kimassignments.knapsack.sorting;

public enum SortingType {
    GREEDY("greedy algorithm"),
    BRUTE_FORCE("brute force technique"),
    MEMOIZATION("memoization technique"),
    FULLY_POLYNOMIAL_TIME_APPROXIMATION("fully polynomial time approximation scheme"),
    BRANCH_AND_BOUND("branch and bound"),
    DYNAMIC_PROGRAMMING("dynamic programming"),
    RECURSIVE_APPROACH("recursive approach");

    public final String value;

    SortingType(String value) {
        this.value = value;
    }
}
