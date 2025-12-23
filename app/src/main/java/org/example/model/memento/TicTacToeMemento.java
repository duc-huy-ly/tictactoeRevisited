package org.example.model.memento;

import org.example.model.tictactoe.Player;
import org.example.model.tictactoe.TicTacToeImpl;

public class TicTacToeMemento implements IMemento{
    private TicTacToeImpl game;
    private Player[][] cells;
    private Player currentPlayer;

    public TicTacToeMemento(TicTacToeImpl game, Player[][] cells, Player currentPlayer) {
        this.game = game;
        this.cells = cells;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void restore() {
        game.setCells(cells);
        game.setCurrentPlayer(currentPlayer);
    }
}
