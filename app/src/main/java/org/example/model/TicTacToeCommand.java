package org.example.model;

public class TicTacToeCommand implements Command {
    private TicTacToeImpl ticTacToe;
    private int i, j;

    public TicTacToeCommand(TicTacToeImpl ticTacToe, int i, int j) {
        this.ticTacToe = ticTacToe;
        this.i = i;
        this.j = j;
    }

    @Override
    public void execute() {
        ticTacToe.play(i, j);
    }
}
