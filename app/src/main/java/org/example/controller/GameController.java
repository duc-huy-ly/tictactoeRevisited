package org.example.controller;

import org.example.model.command.Command;
import org.example.model.tictactoe.Player;
import org.example.model.tictactoe.TicTacToe;
import org.example.model.tictactoe.TicTacToeImpl;
import org.example.view.View;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private View view;
    private final TicTacToeImpl game = new TicTacToeImpl();
    private Deque<Command> history = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);

    public GameController(View view) {
        this.view = view;
    }

    public void updateDisplays(View view, TicTacToe game) {
        view.update(game);
        game.printGrid();

    }

    public void start(){
        while (!game.isFinished()) {
            updateDisplays(view, game);
            System.out.println("Current Player : " + game.currentPlayer());
            System.out.println("Possible commands : ");
            int i = 0;
            List<Command> commands = game.getPossibleCommands();
            for (Command c : commands) {
                System.out.println("> " + i++ + " : " + c.toString());
            }
            if (!history.isEmpty()) {
                System.out.println("> -1 : Undo ");
            }
            System.out.println("Enter command number :");
            int myInt = scanner.nextInt();
            if (myInt > -1 && myInt < commands.size()) {
                history.addFirst(commands.get(myInt));
                commands.get(myInt).execute();
            }
            if (myInt == -1 && !history.isEmpty()) {
                history.pollFirst().undo();
            }
        }
        updateDisplays(view, game);
        if (game.getWinner() == Player.NONE) {
            System.out.println("Draw");
        } else {
            System.out.println(game.getWinner() + " won !");
        }
    }
}
