package com.kimassignments.knapsack;

  public class UnlimitedBag extends Bag {
    UnlimitedBag(Bag bag) {
        super(Double.MAX_VALUE, bag.items);
    }

    public UnlimitedBag() {
        super(Double.MAX_VALUE);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public UnlimitedBag clone() {
        return new UnlimitedBag(this);
    }
}
