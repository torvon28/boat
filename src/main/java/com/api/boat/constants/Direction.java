package com.api.boat.constants;

public enum Direction {
    N(1),
    E(1),
    S(-1),
    W(-1);

    // increment value for the boat to move forward.
    private int incrementValue;

    private Direction(int incrementValue) {
        this.incrementValue = incrementValue;
    }

    public int getIncrementValue() {
        return this.incrementValue;
    }
}