package org.example.model.tictactoe;

public enum Player {
    X, O, NONE;


    @Override
    public String toString() {
        String res = "";
        switch (this) {
            case O -> res = "O";
            case X -> res = "X";
            case NONE -> res = " ";
        }
        return res;
    }
}
