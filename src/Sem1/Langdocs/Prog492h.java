package Sem1.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog492h {
    public static void main(String[] args) throws IOException {
        boolean[][] grid = new boolean[30][30];
        Scanner in = new Scanner(new File("Langdats/prog492h.dat"));

        for (int i = 0; i < 30 && in.hasNextLine(); i++) {
            String lineChars = in.nextLine();
            for (int j = 0; j < 30; j++)
                grid[i][j] = (j < lineChars.length()) && (lineChars.charAt(j) ==  '*');
        }

        for (int gen = 0; gen <= 15; gen++) {
            System.out.println("Generation " + gen);
            printGrid(grid);
            grid = nextGeneration(grid);
        }
    }

    private static void printGrid(boolean[][] grid) {
        for (boolean[] row : grid) {
            for (boolean cell : row)
                System.out.print(cell ? '*' : ' ');
            System.out.println();
        }
        System.out.println();
    }

    public static boolean[][] nextGeneration(boolean[][] grid) { // gross nightmare method that I hate.
        boolean[][] next = new boolean[30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                int neighbors = 0;
                for (int r = -1; r <= 1; r++)
                    for (int c = -1; c <= 1; c++) {
                        if (r == 0 && c == 0) continue;
                        int nr = i + r, nc = j + c;
                        if (nr >= 0 && nr < 30 && nc >= 0 && nc < 30 && grid[nr][nc])
                            neighbors++;
                    }
                next[i][j] = grid[i][j] ? (neighbors == 2 || neighbors == 3) : (neighbors == 3);
            }
        }
        return next;
    }
}
