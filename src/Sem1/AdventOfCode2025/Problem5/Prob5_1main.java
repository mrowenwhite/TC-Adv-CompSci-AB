package Sem1.AdventOfCode2025.Problem5;

import java.io.*;
import java.util.*;

public class Prob5_1main {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Sem1/AdventOfCode2025/Problem5/p5bigData.txt"));
        ArrayList<Long[]> ranges = new ArrayList<>();
        Set<Long> used = new HashSet<>();

        int count = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.contains("-")) {
                String[] arr = line.split("-");
                ranges.add(new Long[]{Long.parseLong(arr[0]), Long.parseLong(arr[1])});
            }
            else {
                if (!line.isEmpty()) {
                    long num = Long.parseLong(line);

                    for (Long[] range : ranges) {
                        if (num >= range[0] && num <= range[1]) {
                            if (!used.contains(num)) {
                                count++;
                            }
                            used.add(num);

                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
