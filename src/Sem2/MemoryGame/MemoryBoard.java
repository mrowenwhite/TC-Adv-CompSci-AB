package Sem2.MemoryGame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryBoard extends JFrame {
    static MemoryBoard memoryBoard;
    static Map<MyButton, MyButton> pairs = new HashMap<>();
    static MyButton[][] Board;
    static MyButton firstClicked;
    static MyButton secondClicked;
    static Timer timer = new Timer(750, e->HideTiles());
    static int pairCount;
    static boolean isPlaying;

    public static class MyButton extends JButton {

        public boolean isFinished;
        Color color;

        public MyButton(Color color) {
            this.color = color;
            timer.setRepeats(false);
            isFinished = false;
            this.setSize(20, 20);
            this.setBackground(Color.DARK_GRAY);
            firstClicked = null;
            secondClicked = null;


            this.addActionListener(e -> {
                this.setOpaque(true);
                this.revalidate();
                this.repaint();
                if (isPlaying) {
                    this.setBackground(color);
                    if (firstClicked == null) {
                        firstClicked=this;
                    }
                    else {
                        secondClicked=this;
                        DisableTiles();
                        if (firstClicked.getColor() == secondClicked.getColor()&&(!(firstClicked==secondClicked))) {
                            firstClicked.setBackground(color);
                            secondClicked.setBackground(color);
                            firstClicked.isFinished=true;
                            secondClicked.isFinished=true;
                            pairCount--;
                            if (pairCount <= 0) {
                                JOptionPane.showMessageDialog(memoryBoard, "All Pairs Matched");
                                memoryBoard.dispose();
                            }
                        }
                        else {
                            timer.start();
                        }
                        firstClicked=null;
                        secondClicked=null;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(memoryBoard, "Press Play");
                }
            });
        }
        public Color getColor() {
            return this.color;
        }
    }
    public MemoryBoard() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(5, 4, 20, 20));
        memoryBoard = this;
        isPlaying = false;


        MyButton[][] board = getBoard();
        for (MyButton[]row: board)for(MyButton temp:row)this.add(temp);
        JButton play = new JButton("Play");

        play.addActionListener(e -> {isPlaying=true;});
        this.add(play, CENTER_ALIGNMENT);
        this.revalidate();
    }

     public static MyButton[][] getBoard() {
        pairCount = 8;
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
         Board = board;
         return board;
     }

     public static void HideTiles() {
        for (MyButton[] row: Board )for(MyButton temp:row){
            temp.setBackground((temp.isFinished)?temp.getColor():Color.DARK_GRAY);
            temp.setEnabled(true);
        }

     }
     public static void DisableTiles() {
        for  (MyButton[] row: Board )for(MyButton temp:row){
            temp.setEnabled(false);
        }
     }

    public static void main(String[] args) {
        new MemoryBoard();
    }

}
