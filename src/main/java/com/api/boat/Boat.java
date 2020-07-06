package com.api.boat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.api.boat.constants.Direction;

public class Boat {

    private static final String FORWARD = "F";
    private static final String BACKWARD = "B";
    private static final String RIGHT = "R";
    private static final String LEFT = "L";
    
    private int x; // boat's current x postion
    private int y; // boat's current y postion

    private List<Direction> compass = Arrays.asList(Direction.N,Direction.E,Direction.S,Direction.W);

    public Boat() {
        // default constructor
    }

    /**
     * Boat constructor based on initial position and current direction that it is facing
     * @param direction - current direction the boat is facing
     * @param x - boat's initial position on x-axis
     * @param y - boat's initial postion on y-axis
     */
    public Boat(String direction, int x, int y) {
        this.x = x;
        this.y = y;

        // turn the compass to the boat's initial direction
        Direction dir;
        try {
            dir = Direction.valueOf(direction);
        } catch (IllegalArgumentException ie) {
            // Set the default direction to North when the inputted direction is invalid
            dir = Direction.N;
        }
        
        turn(compass.indexOf(dir) * -1);
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Navigate the boat using the specified commands.
     * @param commands
     */
    public void navigate(String commands) {
        List<String> commandList = Arrays.asList(commands.split(""));

        for (String str : commandList) {
            String command = str == null ? null : str.toUpperCase();

            switch(command) {
                case FORWARD:
                case BACKWARD:
                    move(command);
                    break;
                case LEFT:
                case RIGHT:
                    turn(command);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Move the boat on the specified movement
     * @param movement - forward or backward
     */
    private void move(String movement) {
        switch(movement) {
            case FORWARD:
                move(1);
                break;
            case BACKWARD:
                move(-1);
                break;
            default:
                break;
        }
    }

    /**
     * Move the boat forward to the direction it is currently facing.
     * @param mode - (-1) - backward, (1) - forward
     */
    private void move(int mode) {
        Direction direction = compass.get(0);
        switch(direction) {
            case N:
            case S:
                this.y = this.y + direction.getAxis() * mode;
                break;
            case E:
            case W:
                this.x = this.x + direction.getAxis() * mode;
                break;
            default:
                break;
        }
    }

    /**
     * Turn the boat into a desired direction
     * @param turnDirection
     */
    private void turn(String turnDirection) {
        switch(turnDirection) {
            case RIGHT:
                turn(-1); // turn the boat to the right
                break;
            case LEFT:
                turn(1); // turn the boat to the left
                break;
            default:
                break;
        }
    }

    /**
     * turn the boat's compass to point to the direction it is currently facing
     * @param distance - negative vale to turn to the right, positive value to turn to the left
     */
    private void turn(int distance) {
        Collections.rotate(compass, distance);
        System.out.println("The boat is currently facing " + compass.get(0));
    }
    
}