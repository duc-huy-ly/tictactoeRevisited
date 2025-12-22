package org.example.model;

import java.util.List;

public interface TicTacToe {
    Player currentPlayer();
    void reset();
    boolean isFinished();
    void play(int i, int j);
    Player getCell(int i, int j);
    Player getWinner();
    List<Command> getPossibleCommands();
}
