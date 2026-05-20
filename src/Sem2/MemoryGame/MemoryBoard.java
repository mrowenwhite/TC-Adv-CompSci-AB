package Sem2.MemoryGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryBoard extends JFrame {
    static MemoryBoard memoryBoard;
    static Map<MyButton, MyButton> pairs = new HashMap<>();
    static MyButton[][] Board;
    static MyButton firstClicked;
    static MyButton secondClicked;
    static boolean isPlaying;
    static Timer timer = new Timer(750, e-> {
        for (MyButton[] row: Board )for(MyButton temp:row){
            if (isPlaying) {
                temp.setBackground((temp.isFinished)?temp.color:Color.DARK_GRAY);
                temp.setEnabled(true);
            }
        }
    });


    static int pairCount;

    public static class MyButton extends JButton {

        public boolean isFinished;
        public Color color;

        public MyButton(Color color) {
            this.color = color;
            timer.setRepeats(false);
            isFinished = false;
            this.setSize(20, 20);
            this.setBackground(Color.DARK_GRAY);
            firstClicked = null;secondClicked = null;
            this.addActionListener(e -> {
                this.setOpaque(true);this.revalidate();this.repaint();
                if (isPlaying) {
                    this.setBackground(color);
                    if (firstClicked == null) {firstClicked=this;}
                    else {
                        secondClicked=this;
                        SetTilesEnabled(false);
                        if (firstClicked.color == secondClicked.color&&(!(firstClicked==secondClicked))) {
                            firstClicked.isFinished=true;firstClicked.setBackground(color);
                            secondClicked.isFinished=true;secondClicked.setBackground(color);
                            pairCount--;

                            if (pairCount <= 0) {JOptionPane.showMessageDialog(memoryBoard, "All Pairs Matched");isPlaying=false;memoryBoard.dispose();}
                            SetTilesEnabled(true);
                        }
                        else {timer.start();}
                        firstClicked=null;
                        secondClicked=null;
                    }
                }
                else {JOptionPane.showMessageDialog(memoryBoard, "Press Play");}
            });
        }
    }
    public MemoryBoard() {
        pairCount = 8;
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(5, 4, 20, 20));
        memoryBoard = this;
        isPlaying = false;
        Board = getBoard();
        for (MyButton[]row: Board)for(MyButton temp:row)this.add(temp);
        JButton play = new JButton("Play");
        GameTimer GT = new GameTimer(60);
        this.add(GT, CENTER_ALIGNMENT);
        play.addActionListener(e -> {isPlaying=true;GT.start();});
        this.add(play, CENTER_ALIGNMENT);
        this.revalidate();
    }
    public static MyButton[][] getBoard() {
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
         for (int lcv=0;lcv<4;lcv++)for(int lcv2=0;lcv2<4;lcv2++)board[lcv][lcv2]=list.get(cnt++);
         return board;
     }
    public static void SetTilesEnabled(boolean b){for (MyButton[] row: Board )for(MyButton temp:row) temp.setEnabled(b);}
    public static void main(String[] args) {new MemoryBoard();}


    public static class GameTimer extends JLabel {
        private int TimeLeft;
        Timer timer = new Timer(1000, e-> {
            TimeLeft--;
            this.setText("TimeLeft: "+TimeLeft/60 + ":" + TimeLeft%60);
            if (TimeLeft <= 0) {
                isPlaying = false;
                JOptionPane.showMessageDialog(memoryBoard, "You Lose!");
                memoryBoard.dispose();
                return;
            }
        });
        GameTimer(int time) {
            this.setText("TimeLeft: "+TimeLeft/60 + ":" + TimeLeft%60);
            TimeLeft = time;
        }
        public void start() {
            timer.start();
        }

    }
}
