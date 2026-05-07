package Sem2.MemoryGame;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameFrame extends JFrame {
    private static MyButton lastCLicked;

    private static Map<MyButton, MyButton> map = new HashMap<>();



    public GameFrame() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(4, 4, 20, 20));
        MyButton[][] board = getBoard();
        int count = 0;
        for  (MyButton[] row : board) {
            for(MyButton temp : row) {
                this.add(temp);
                count++;
                System.out.println(temp.getColor() + " " + count);
            }
        }
        this.revalidate();
    }

    private MyButton[][] getBoard() {
        MyButton[] buttons = new MyButton[16];
        MyButton[][] board = new MyButton[4][4];
        final Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.WHITE};
        for (int i = 0; i < buttons.length; i+=2) {
            buttons[i]   = new MyButton( COLORS[i/2]);
            buttons[i+1] = new MyButton(COLORS[i/2]);
            map.put(buttons[i], buttons[i+1]);
            map.put(buttons[i+1], buttons[i]);
        }
        Collections.shuffle(Arrays.asList(buttons));

        int cnt = 0;
        for (int lcv = 0; lcv < 4; lcv++) {
            for (int lcv2 = 0; lcv2 < 4; lcv2++) {
                board[lcv][lcv2] = buttons[cnt];
                cnt++;
            }
        }
        return  board;
    }


    private static class MyButton extends JButton {
        private final Color color;

        public MyButton(Color color) {
            this.color = color;
            this.setSize(20, 20);
            this.setBackground(Color.DARK_GRAY);

            this.addActionListener(e -> {
                if (map.get(this).isPair(lastCLicked)) {
                    this.ShowAndDisablePair();
                }
                lastCLicked = this;
            });
        }

        public void ShowAndDisablePair() {
            this.setBackground(color);
            map.get(this).setBackground(color);
            this.setEnabled(false);
            map.get(this).setEnabled(false);
        }

        public MyButton getPair() {return map.get(this);}
        public Color getColor() {return this.color;}

        public boolean isPair(MyButton other) {
            return other.getColor().equals(this.color);
        }


    }
}
