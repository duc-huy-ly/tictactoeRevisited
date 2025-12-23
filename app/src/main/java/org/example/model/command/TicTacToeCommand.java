package org.example.model.command;

import org.example.model.memento.IMemento;
import org.example.model.tictactoe.TicTacToeImpl;

public class TicTacToeCommand implements Command {
    private TicTacToeImpl ticTacToe;
    private IMemento previous;
    private int i, j;

    public TicTacToeCommand(TicTacToeImpl ticTacToe, int i, int j) {
        this.ticTacToe = ticTacToe;
        this.i = i;
        this.j = j;
    }

    @Override
    public void execute() {
        previous = ticTacToe.createSnapshot();
        ticTacToe.play(i, j);
    }

    @Override
    public void undo() {

        if (previous != null) {
            previous.restore();
        }
    }

    @Override
    public String toString() {
        return "[" + i + "][" + j + "]";
    }
}
