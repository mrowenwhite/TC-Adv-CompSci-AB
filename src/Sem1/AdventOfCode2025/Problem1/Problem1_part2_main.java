package Sem1.AdventOfCode2025.Problem1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem1_part2_main {
    static int pos = 50, move = 0, count = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Sem1/AdventOfCode2025/Problem1/p1_BigData.txt"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("L"))tickLeft(Integer.parseInt(line.substring(1)));
            if (line.startsWith("R"))tickRight(Integer.parseInt(line.substring(1)));
        }
        System.out.println(count);
    }

    public static void tickRight(int move) {for (int i=0;i<move;i++){pos++;if (pos>99){pos = 0;count++; }}}
    public static void tickLeft(int move)  {for (int i=0;i<move;i++){pos--;if (pos<=0){pos = 99;count++;}}}
}
//6616 should be correct: code runs 6684

