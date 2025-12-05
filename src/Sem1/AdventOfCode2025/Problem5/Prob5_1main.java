package Sem1.AdventOfCode2025.Problem5;

import java.io.*;
import java.util.*;

public class Prob5_1main {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Sem1/AdventOfCode2025/Problem5/p5bigData.txt"));
        ArrayList<Long[]> ranges = new ArrayList<>();
        int count = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.contains("-")) {
                String[] arr = line.split("-");
                ranges.add(new Long[]{Long.parseLong(arr[0]), Long.parseLong(arr[1])});
            }
            else {
                if (line.isEmpty()) continue;
                long num = Long.parseLong(line);

                for  (int i = 0; i < ranges.size(); i++) {
                    if (ranges.get(i)[0] <= num && ranges.get(i)[1] >= num) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
