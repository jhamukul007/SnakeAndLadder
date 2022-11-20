package com.sl.models;

import com.sl.console.Logger;

public class Ladder implements Movement{
    private Position staringPosition;
    private Position endPosition;
    private final Logger logger;

    public Ladder(Position staringPosition, Position endPosition, Logger logger) {
        this.staringPosition = staringPosition;
        this.endPosition = endPosition;
        this.logger = logger;
    }

    public Position getStaringPosition() {
        return staringPosition;
    }

    public void setStaringPosition(Position staringPosition) {
        this.staringPosition = staringPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public void move(Player player) {
        logger.log("Yeh !!! It's ladder !!!! Movie to new Position " + endPosition + "from : " + player.getCurrentPosition());
        player.setCurrentPosition(endPosition);
        player.setCurrentValue(endPosition.getValue());
    }
}
