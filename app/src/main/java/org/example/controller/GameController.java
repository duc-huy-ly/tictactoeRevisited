package org.example.controller;

import org.example.model.command.Command;
import org.example.model.tictactoe.Player;
import org.example.model.tictactoe.TicTacToe;
import org.example.view.View;

import java.util.*;

public class GameController {
    private View view;
    private final TicTacToe game;
    private Deque<Command> history = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    private List<Command> commands;

    public GameController(View view, TicTacToe game) {
        this.view = view;
        this.game = game;
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
            commands = game.getPossibleCommands();
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
        checkWinner(game);
    }

    public void startGui() {
        commands = game.getPossibleCommands();
    }

    public void executeAction(int ButtonIdClicked) {
        // map the i received from the view to the correct command number
        int[] idToCommandNumber = new int[9];
        int counter = 0;
        for (int i = 0; i < 3; i++) { // number of rows
            for (int j = 0; j < 3; j++) {
                if (game.getCell(i, j).isOccupied()) {
                    // Call an invalid command number when we click on a already occupied cell
                    idToCommandNumber[i*3 + j] = -99;
                }
                idToCommandNumber[i * 3 + j] = counter++;
            }
        }
        history.addFirst(commands.get(idToCommandNumber[ButtonIdClicked]));
        commands.get(idToCommandNumber[ButtonIdClicked]).execute();

        view.update(game);
        if (game.isFinished()) {
            checkWinner(game);
        }

    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pollFirst().undo();
            view.update(game);
        }
    }

    private void checkWinner(TicTacToe game) {
        if (game.getWinner() == Player.NONE) {
            System.out.println("Draw");
        } else {
            System.out.println(game.getWinner() + " won !");
        }
    }


    public void reset() {
        game.reset();
        view.update(game);
        System.out.println("Reset");
    }
}
