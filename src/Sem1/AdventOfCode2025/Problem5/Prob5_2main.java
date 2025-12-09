package Sem1.AdventOfCode2025.Problem5;

import  java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Prob5_2main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("src/Sem1/AdventOfCode2025/Problem5/p5littleData.txt"));
        int freshes = 0;
        while (scan.hasNextLine()) {
            List<Range> rangeList = new ArrayList<>();
            String line = scan.nextLine();
            rangeList.add(new Range(Integer.parseInt(line.substring(0, line.indexOf("-"))),Integer.parseInt(line.substring(line.indexOf("-")+1))));
            rangeList = rangeList.stream().sorted().collect(Collectors.toList());
            //TBD adjust starts and ends.

        }

    }
    public static class Range {
        int start;int end;
        public Range(int start, int end) {this.start = start;this.end = end;}
        public int getStart() {return start;}
        public int getEnd() {return end;}
    }


}
