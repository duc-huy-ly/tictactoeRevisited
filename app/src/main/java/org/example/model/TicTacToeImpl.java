package org.example.model;

import java.util.Arrays;
import java.util.List;

public class TicTacToeImpl implements TicTacToe{
    private Player[] cells;
    private Player currentPlayer;
    
    public TicTacToeImpl(){
        cells = new Player[9];
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
        Arrays.fill(cells, Player.NONE);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void play(int i) {
    }

    public Player getCell(int i){
        return cells[i];
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public List<Command> getPossibleCommands() {
        return List.of();
    }

    public void printGrid(){
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j++){
                System.out.printf("|"+ cells[i].toString());
            }
            System.out.print("|\n");
        }
    }

}
