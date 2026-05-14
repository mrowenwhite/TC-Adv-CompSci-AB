package Sem2.MemoryGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

public class GameFrame extends JFrame {
    private static MyButton lastCLicked;
    private static Timer timer;

    private static final Map<MyButton, MyButton> map = new HashMap<>();



    public GameFrame() {
        this.setTitle("Memory Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(842, 480);
        this.setVisible(true);
        this.setLayout(new GridLayout(4, 4, 20, 20));


        MyButton[][] board = getBoard();
        for (MyButton[]row: board)for(MyButton temp:row)this.add(temp);
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







    public static void main(String[] args) {
        new GameFrame();
    }
}
