package org.example.model;

import java.util.List;

public interface TicTacToe {
    Player currentPlayer();
    void reset();
    boolean isFinished();
    void play(int i);
    Player getCell(int i);
    Player getWinner();
    List<Command> getPossibleCommands();
}
