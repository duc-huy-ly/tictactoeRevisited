package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeImpl implements TicTacToe {
    public static class Memento{
        private final Player [][] cells;
        private final Player currentPlayer;

        private Memento(Player[][] cells, Player currentPlayer) {
            this.cells = cells;
            this.currentPlayer = currentPlayer;
        }

        private Player[][] getCells() {
            return cells;
        }

        private Player getCurrentPlayer() {
            return currentPlayer;
        }
    }
    private Player[][] cells;
    private Player currentPlayer;
    
    public TicTacToeImpl(){
        cells = new Player[3][3];
        reset();
    }

    @Override
    public Player currentPlayer() {
        if (isFinished()) {
            return Player.NONE;
        }
        return currentPlayer;
    }

    @Override
    public void reset() {
        for( int i = 0 ; i < 3 ; i ++){
            Arrays.fill(cells[i], Player.NONE);
        }
        currentPlayer = Player.X;
    }

    @Override
    public boolean isFinished() {
        if (getWinner() != Player.NONE) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == Player.NONE) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void play(int i, int j) {
        if (isFinished()) {
            currentPlayer = Player.NONE;
            throw new UnsupportedOperationException();
        }
        cells[i][j] = currentPlayer;
        if (currentPlayer == Player.X) {
            currentPlayer = Player.O;
        } else {
            currentPlayer = Player.X;
        }
    }

    public Player getCell(int i, int j){
        return cells[i][j];
    }

    @Override
    public Player getWinner() {
        for (int i = 0; i < cells.length; i++) {
            // rows
            int xcount = 0;
            int ocount = 0;
            for (int j = 0; j < cells.length; j++) {
                if(cells[i][j] == Player.X) xcount++;
                if(cells[i][j] == Player.O) ocount++;
            }
            if (xcount == 3) return Player.X;
            if (ocount == 3) return Player.O;
            // columns
            xcount = 0;
            ocount = 0;
            for (int j = 0; j < cells.length; j++) {
                if(cells[j][i] == Player.X) xcount++;
                if(cells[j][i] == Player.O) ocount++;
            }
            if (xcount == 3) return Player.X;
            if (ocount == 3) return Player.O;
        }
        //diagonal
        int xcount =0;
        int ocount = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][i] == Player.O) ocount++;
            if (cells[i][i] == Player.X) xcount++;
        }
        if (xcount == 3) return Player.X;
        if (ocount == 3) return Player.O;
        //inverted diagonal
        xcount = 0 ;
        ocount = 0;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][2 -i] == Player.O) ocount++;
            if (cells[i][2 - i] == Player.X) xcount++;
        }
        if (xcount == 3) return Player.X;
        if (ocount == 3) return Player.O;
        return Player.NONE;
    }

    @Override
    public List<Command> getPossibleCommands() {
        List<Command> result = new ArrayList<Command>();
        if (!isFinished()) {
            for (int i = 0 ; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cells[i][j] == Player.NONE) {
                        result.add(new TicTacToeCommand(this, i, j));
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Memento createSnapshot() {
        return new Memento(cells, currentPlayer);
    }

    @Override
    public void restore(Memento m) {
        this.cells = m.getCells();
        this.currentPlayer = m.getCurrentPlayer();
    }

    public void printGrid(){
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j++){
                System.out.printf("|"+ cells[i][j].toString());
            }
            System.out.print("|\n");
        }
    }

}
