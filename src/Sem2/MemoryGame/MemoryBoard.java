package Sem2.MemoryGame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryBoard extends JFrame {
    static Map<MyButton, MyButton> pairs = new HashMap<>();
    static MyButton lastClicked = null;


    public static class MyButton extends JButton {
        static Timer timer = new Timer(750, e->HideTiles());
        public boolean isFinished;

        public MyButton(Color color) {
            timer.setRepeats(false);
            isFinished = false;
            this.setSize(20, 20);
            this.setBackground(Color.DARK_GRAY);

            this.addActionListener(e -> {
                secondClicked=this;
                this.setBackground(color);
                if ((pairs.get(firstClicked) != null)&&(pairs.get(firstClicked)==this)) {
                    this.setBackground(color);
                    firstClicked.setBackground(color);
                    isFinished = true;
                    secondClicked.isFinished = true;

                }
                else {
                    timer.start();
                    while  (timer.isRunning())continue;
                    timer.stop();
                }
            });
        }

        public static void HideTiles() {} //TODO
    }
    public MemoryBoard() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(4, 4, 20, 20));


        MyButton[][] board = getBoard();
        for (MyButton[]row: board)for(MyButton temp:row)this.add(temp);
        this.revalidate();
    }

     public MyButton[][] getBoard() {
         ArrayList<MyButton> list   = new ArrayList<>();
         MyButton[][]        board  = new MyButton[4][4];
         final Color[]       COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.WHITE};

         for (Color color : COLORS) {
             list.add(new MyButton(color));
             list.add(new MyButton(color));
             pairs.put(list.getLast(), list.get(list.size()-2));
             pairs.put(list.get(list.size()-2), list.getLast());
         }
         Collections.shuffle(list);

         int cnt = 0;
         for (int lcv = 0; lcv < 4; lcv++)
             for (int lcv2 = 0; lcv2 < 4; lcv2++)
                 board[lcv][lcv2] = list.get(cnt++);
         return board;
     }

    public static void main(String[] args) {
        new MemoryBoard();
    }

}
