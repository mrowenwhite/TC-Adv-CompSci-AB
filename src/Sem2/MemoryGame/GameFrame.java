package Sem2.MemoryGame;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFrame extends JFrame {
    public static MyButton lastCLicked;

    public GameFrame() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 1200); // TBD
        this.setVisible(true);
        MyButton[][] board = getBoard();



        this.revalidate();
    }

    private MyButton[][] getBoard() {
        MyButton[] buttons = new MyButton[16];
        MyButton[][] board = new MyButton[4][4];
        final Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.WHITE};
        for (int i = 0; i < buttons.length-1; i+=2) {
            buttons[i]   = new MyButton(buttons[i+1], COLORS[i/2]);
            buttons[i+1] = new MyButton(buttons[i],   COLORS[i/2]);
        }
        Collections.shuffle(Arrays.asList(buttons));
        board[0] = Arrays.copyOfRange(buttons, 0, 3);
        board[1] = Arrays.copyOfRange(buttons, 4, 7);
        board[2] = Arrays.copyOfRange(buttons, 8, 11);
        board[3] = Arrays.copyOfRange(buttons, 12, 15);
        return  board;
    }


    private static class MyButton extends JButton {
        private final MyButton pair;
        private final Color color;

        public MyButton(MyButton pair, Color color) {
            this.pair = pair;
            this.color = color;
            this.setSize(20, 20);
            this.setBackground(color);

            this.addActionListener(e -> {
                lastCLicked = this;
                if (lastCLicked == pair) {
                    this.ShowAndDisablePair();
                }
            });
        }

        public void ShowAndDisablePair() {
            this.setBackground(color);
            pair.setBackground(color);
            this.setEnabled(false);
            pair.setEnabled(false);
        }

        public MyButton getPair() {return this.pair;}
        public Color getColor() {return this.color;}


    }
}
