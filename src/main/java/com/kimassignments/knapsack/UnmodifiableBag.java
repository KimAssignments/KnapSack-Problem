package com.kimassignments.knapsack;

import java.util.Collections;
import java.util.List;

public class UnmodifiableBag extends Bag {
    UnmodifiableBag(Bag bag) {
        super(bag.maxWeightInGrams, Collections.unmodifiableList(bag.items));
    }

    @Override
    public void add(Item item) {
        throw new UnsupportedOperationException("Cannot add to unmodifiable bag");
    }

    @Override
    public void add(List<Item> items) {
        throw new UnsupportedOperationException("Cannot add to unmodifiable bag");
    }

    @Override
    public Item remove(int index) {
        throw new UnsupportedOperationException("Cannot remove from unmodifiable bag");
    }

    @Override
    public UnmodifiableBag clone() {
        return new UnmodifiableBag(this);
    }
}
