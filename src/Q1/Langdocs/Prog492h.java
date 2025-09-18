package Q1.Langdocs;

import java.util.*;
import java.io.*;

public class Prog492h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/prog492h.dat"));

        String[][] mat = new String[30][30];
        String[][] ans = new String[30][30];

        //populate
        int r = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] chars = line.split("");
            mat[r] = chars;
            r++;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int neighborCount = LiveNeighborCount(i, j, mat);

            }
        }
    }


    public static int LiveNeighborCount(int row, int col, String[][] mat) {
        int cnt = 0;
        for (int r = row - 1; r <= row + 1; r++)
            for (int c = col - 1; c <= col + 1; c++)
                if ((!(row == r && col == c)) && ((c >= 0 && r >= 0) && (c <= (col + 1) && r <= (row + 1))))
                    cnt++;
        return cnt;
    }
}


