package com.sl.models;

public interface Game {
    void play(Player player, GameBoard gameBoard);
    void start(GameBoard gameBoard);
}
