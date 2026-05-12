package Sem2.MemoryGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class GameFrame extends JFrame {
    private static MyButton lastCLicked;
    private static Timer timer;
    private static MyButton[][] board;

    private static Map<MyButton, MyButton> map = new HashMap<>();



    public GameFrame() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(4, 4, 20, 20));
        board = getBoard();
        for (MyButton[]row:board)for(MyButton temp:row)this.add(temp);
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
        lastCLicked =  new MyButton(Color.cyan);
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
        public boolean isFinished;

        public MyButton(Color color) {
            isFinished = false;
            this.color = color;
            this.setSize(20, 20);
            this.setBackground(Color.DARK_GRAY);
            timer = new Timer(750, event -> {HideTiles();});
            timer.setRepeats(false);

            this.addActionListener(e -> {
                this.setBackground(color);

                if (lastCLicked == null)
                    lastCLicked =  new MyButton(Color.cyan); // instantiated without a pairing

                if (map.get(this)==lastCLicked) {ShowAndDisablePair();}
                else {
                    timer.start();
                    while (timer.isRunning())continue; // do nothing until timer ends
                    EnableTiles();
                    ResetPair();


                }
                lastCLicked = this;
            });
        }

        public void EnableTiles() {
            for (MyButton[] row:board) {
                for (MyButton temp:row) {
                    temp.setEnabled(false);
                }
            }
        }


        public void ShowAndDisablePair() {
            this.setBackground(color);
            this.isFinished = true;
            this.setEnabled(false);
            map.get(this).setBackground(color);
            map.get(this).isFinished = true;
            map.get(this).setEnabled(false);
        }
        public void ResetPair() {
            if (!(isFinished &&map.get(this).isFinished)) {
                this.setBackground(Color.DARK_GRAY);
                map.get(this).setBackground(Color.DARK_GRAY);
            }
        }
        public Color getColor() {return this.color;}

    }

    public static void HideTiles() {
        for  (MyButton[] row : board) {
            for (MyButton temp : row) {
                if (!temp.isFinished){
                    temp.setBackground(Color.DARK_GRAY);
                    temp.setEnabled(false);
                }
            }
        }
    }
}
