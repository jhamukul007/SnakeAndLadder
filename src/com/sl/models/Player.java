package com.sl.models;


import com.sl.enums.Color;

public class Player {
    private String name;
    private Color color;
    private Position currentPosition;
    private int currentValue;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.currentValue = 0;
       // this.currentPosition = new Position(9,0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return color == player.color;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
