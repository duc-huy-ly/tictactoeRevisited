package org.example.model.tictactoe;

import org.example.model.command.Command;
import org.example.model.memento.IMemento;

import java.util.List;

public interface TicTacToe {
    Player currentPlayer();
    void reset();
    boolean isFinished();
    void play(int i, int j);
    Player getCell(int i, int j);
    Player getWinner();
    List<Command> getPossibleCommands();
    IMemento createSnapshot();
    void printGrid();
}
