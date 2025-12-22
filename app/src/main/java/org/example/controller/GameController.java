package org.example.controller;

import org.example.model.TicTacToeImpl;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GameController {
    private final TicTacToeImpl game = new TicTacToeImpl();
    private Deque<TicTacToeImpl.Memento> history = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    public void start(){
        while (!game.isFinished()) {
            game.printGrid();
            System.out.println("Enter command number :");
            int myInt = scanner.nextInt();

            System.out.println(myInt);
        }
    }
}
