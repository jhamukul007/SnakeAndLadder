package com.sl.models;

import java.util.HashMap;

import java.util.Map;

public class GameBoard {
    Map<Position, Integer> numberOnPosition;
    Map<Integer, Position> positionOnNumber;

    public GameBoard() {
        this.numberOnPosition = new HashMap<>();
        this.positionOnNumber = new HashMap<>();
        createPosition();
    }

    void createPosition() {
        int count = 1;
        int row = 0;
        int col = 0;
        int value = 100;
        while(row < 10){
            while(col < 10 && col >= 0){
                Position position = new Position(row, col, value);
                numberOnPosition.put(position, position.getValue());
                positionOnNumber.put(value, position);
                if(count % 2 != 0){
                    col++;
                }
                else
                    col--;
                value--;
            }
            count++;
            row++;
            if(col < 0){
                col++;
            }
            if(col >= 10)
                col--;
        }
    }

    public Integer getValueOnPosition(Position position){
        return numberOnPosition.get(position);
    }

    public Position getPositionFromValue(Integer value){
        return positionOnNumber.get(value);
    }

}
