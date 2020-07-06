package com.api.boat.constants;

public enum Direction {
    N(1),
    E(1),
    S(-1),
    W(-1);

    // increment value for the boat to move forward.
    private int axis;

    private Direction(int axis) {
        this.axis = axis;
    }

    public int getAxis() {
        return this.axis;
    }
}