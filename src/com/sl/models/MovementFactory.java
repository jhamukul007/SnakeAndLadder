package com.sl.models;

import com.sl.exceptions.InvalidPositionException;

import java.util.HashMap;
import java.util.Map;

public class MovementFactory {
    private Map<Integer, Movement> snakes;
    private Map<Integer, Movement> ladders;
    private final GameBoard gameBoard;

    public MovementFactory(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public Movement isSnakesOrLadder(int position){
        return snakes.get(position) == null ? ladders.get(position) : snakes.get(position);
    }

    public void addSnakes(Snake snake){
        if(ladders.get(snake.getStaringPosition().getValue()) != null)
            throw new InvalidPositionException("Can't put snake and ladder on same position ");
        snakes.put(gameBoard.getValueOnPosition(snake.getStaringPosition()), snake);
    }

    public void addLadder(Ladder ladder){
        if(snakes.get(ladder.getStaringPosition().getValue()) != null)
            throw new InvalidPositionException("Can't put snake and ladder on same position ");
        ladders.put(gameBoard.getValueOnPosition(ladder.getStaringPosition()), ladder);
    }

}
