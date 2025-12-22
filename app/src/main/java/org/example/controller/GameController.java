package org.example.controller;

import org.example.model.TicTacToeImpl;

import java.util.Scanner;

public class GameController {
    private final TicTacToeImpl game = new TicTacToeImpl();
    Scanner scanner = new Scanner(System.in);
    

    public void start(){
        while (!game.isFinished()) {
            game.printGrid();
            System.out.println("Enter command number :");
            int myint = scanner.nextInt();
            System.out.println(myint);
        }
    }
}
