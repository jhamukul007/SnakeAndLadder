package com.sl;

import com.sl.console.ConsoleLogger;
import com.sl.console.Logger;
import com.sl.enums.Color;
import com.sl.models.GameBoard;
import com.sl.models.Ladder;
import com.sl.models.MovementFactory;
import com.sl.models.Player;
import com.sl.models.Snake;
import com.sl.models.SnakeAndLadderGame;

public class GameRunner {

    public static void main(String[] args) {

        Logger logger = new ConsoleLogger();
        GameBoard gameBoard = new GameBoard();
        MovementFactory movementFactory = new MovementFactory(gameBoard);
        SnakeAndLadderGame game = new SnakeAndLadderGame(movementFactory, logger);

        Snake snake1 = new Snake(gameBoard.getPositionFromValue(97), gameBoard.getPositionFromValue(78), logger);
        Snake snake2 = new Snake(gameBoard.getPositionFromValue(95), gameBoard.getPositionFromValue(56), logger);
        Snake snake3 = new Snake(gameBoard.getPositionFromValue(88), gameBoard.getPositionFromValue(24), logger);
        Snake snake4 = new Snake(gameBoard.getPositionFromValue(62), gameBoard.getPositionFromValue(18), logger);
        Snake snake5 = new Snake(gameBoard.getPositionFromValue(48), gameBoard.getPositionFromValue(26), logger);
        Snake snake6 = new Snake(gameBoard.getPositionFromValue(36), gameBoard.getPositionFromValue(6), logger);

        logger.log("Adding snakes to the board: ");
        movementFactory.addSnakes(snake1);
        movementFactory.addSnakes(snake2);
        movementFactory.addSnakes(snake3);
        movementFactory.addSnakes(snake4);
        movementFactory.addSnakes(snake5);
        movementFactory.addSnakes(snake6);

        Ladder ladder0 = new Ladder(gameBoard.getPositionFromValue(1), gameBoard.getPositionFromValue(38), logger);
        Ladder ladder1 = new Ladder(gameBoard.getPositionFromValue(4), gameBoard.getPositionFromValue(14), logger);
        Ladder ladder2 = new Ladder(gameBoard.getPositionFromValue(8), gameBoard.getPositionFromValue(30), logger);
        Ladder ladder3 = new Ladder(gameBoard.getPositionFromValue(21), gameBoard.getPositionFromValue(42), logger);
        Ladder ladder4 = new Ladder(gameBoard.getPositionFromValue(28), gameBoard.getPositionFromValue(76), logger);
        Ladder ladder5 = new Ladder(gameBoard.getPositionFromValue(50), gameBoard.getPositionFromValue(67), logger);
        Ladder ladder6 = new Ladder(gameBoard.getPositionFromValue(71), gameBoard.getPositionFromValue(92), logger);
        Ladder ladder7 = new Ladder(gameBoard.getPositionFromValue(80), gameBoard.getPositionFromValue(99), logger);

        logger.log("Adding ladders to the board: ");
        movementFactory.addLadder(ladder0);
        movementFactory.addLadder(ladder1);
        movementFactory.addLadder(ladder2);
        movementFactory.addLadder(ladder3);
        movementFactory.addLadder(ladder4);
        movementFactory.addLadder(ladder5);
        movementFactory.addLadder(ladder6);
        movementFactory.addLadder(ladder7);

        Player player1 = new Player("Mukul", Color.RED);
        Player player2 = new Player("Mohan", Color.GREEN);
        Player player3 = new Player("Raju", Color.YELLOW);
        Player player4 = new Player("Jack", Color.BLUE);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);

        game.start(gameBoard);
    }
}
