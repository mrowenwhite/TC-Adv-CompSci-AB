package Sem2.MemoryGame;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class MemoryBoard {

     public MemoryBoard(int n) {
          MyButton[][] board = getBoard();


     }

     public MyButton[][] getBoard() {
         ArrayList<MyButton> list   = new ArrayList<>();
         MyButton[][]        board  = new MyButton[4][4];
         final Color[]       COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.MAGENTA, Color.WHITE};

         for (Color color : COLORS) {
             list.add(new MyButton(color));
             list.add(new MyButton(color));
         }
         Collections.shuffle(list);

         int cnt = 0;
         for (int lcv = 0; lcv < 4; lcv++) {
             for (int lcv2 = 0; lcv2 < 4; lcv2++) {
                 board[lcv][lcv2] = list.get(cnt);
                 cnt++;
             }
         }
         return board;
     }

}
