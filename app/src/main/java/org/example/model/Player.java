package org.example.model;

public enum Player {
    X, O, NONE;


    @Override
    public String toString() {
        String res = "";
        switch (this) {
            case O -> res = "X";
            case X -> res = "O";
            case NONE -> res = " ";
        }
        return res;
    }
}
