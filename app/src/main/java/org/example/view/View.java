package org.example.view;

import org.example.controller.GameController;
import org.example.model.tictactoe.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener {
    private JFrame frame = new JFrame("Tic Tac Toe");
    private JPanel game_grid = new JPanel();
    private JPanel bottom_panel = new JPanel();
    private JButton[] buttons = new JButton[9];
    private JButton undo = new JButton("Undo");
    private JButton reset = new JButton("Reset game");

    private GameController controller;

    public View() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        game_grid.setLayout(new GridLayout(3,3));
        game_grid.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            game_grid.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.add(game_grid, BorderLayout.CENTER);
        reset.setFont(new Font("MV Boli", Font.BOLD, 20));
        reset.setFocusable(false);
        reset.addActionListener(this);
        bottom_panel.add(reset);

        undo.setFont(new Font("MV Boli", Font.BOLD, 20));
        undo.setFocusable(false);
        undo.addActionListener(this);
        bottom_panel.add(undo);
        frame.add(bottom_panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (int i = 0; i < 9; i++) {
            if (actionEvent.getSource() == buttons[i]) {
                controller.executeAction(i);
            }
        }
        if (actionEvent.getSource() == undo) {
            controller.undo();
        }
        if (actionEvent.getSource() == reset) {
            controller.reset();
        }
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public void update(TicTacToe game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i*3+j].setText(game.getCell(i,j).toString());
            }
        }
    }
}
