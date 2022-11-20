package com.sl.models;

import com.sl.console.Logger;
import com.sl.exceptions.GameOverException;
import com.sl.exceptions.PlayerNotJoinedException;
import com.sl.utils.CollectionUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SnakeAndLadderGame implements Game {

    private final List<Player> players;
    private final Random random;
    private final MovementFactory movementFactory;
    private final Logger logger;
    private boolean isOver = false;

    public SnakeAndLadderGame(MovementFactory movementFactory, Logger logger) {
        this.movementFactory = movementFactory;
        this.logger = logger;
        this.players = new LinkedList<>();
        this.random = new Random();
    }


    private int throwDice() {
        int high = 6;
        int low = 1;
        return random.nextInt(high - low) + low;
    }

    @Override
    public void play(Player player, GameBoard gameBoard) {
        logger.log("Playing :: " + player.getName());
        int points = throwDice();
        logger.log(String.format("Player %s :: thrown dice :: got %s", player.getName(), points));
        Position currentPosition = player.getCurrentPosition();
        int newPositionVal = currentPosition.getValue() + points;
        if (newPositionVal > 100) {
            logger.log("can't move to " + newPositionVal);
            play(getNextPlayer(), gameBoard);
        }
        if(newPositionVal == 100){
            logger.log("Winner of the game : " + player.getName() + " !!!!");
            logger.log("Game is Over Now !!!");
            throw new GameOverException("Game is over now !!!");
        }

        Movement movement = movementFactory.isSnakesOrLadder(newPositionVal);
        if(movement != null)
            movement.move(player);
        else{
            Position position = gameBoard.getPositionFromValue(newPositionVal);
            logger.log("Moving player " + player.getName()+ " to new position " + position + " from : " + player.getCurrentPosition());
            player.setCurrentPosition(position);
            player.setCurrentValue(position.getValue());
        }
        play(getNextPlayer(), gameBoard);
    }

    @Override
    public void start(GameBoard gameBoard) {
        isAllowToPlay();
        play(players.get(0), gameBoard);
    }

    private boolean isAllowToPlay() {
        if (CollectionUtil.isEmpty(players))
            throw new PlayerNotJoinedException("Player yet to be join");
        if (players.size() == 1)
            throw new PlayerNotJoinedException("Minimum 2 players required to play game");
        return true;
    }

    private Player getNextPlayer() {
        Player playedPlayer = players.remove(0);
        players.add(playedPlayer);
        return players.get(0);
    }

    public void addPlayer(Player player){
        Position position = new Position(9, -1, 0);
        player.setCurrentPosition(position);
        player.setCurrentValue(0);
        players.add(player);
    }


}
