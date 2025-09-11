package Langdocs;

import java.io.*;
import java.util.*;

public class Prog404a {
    public static void main(String[] args) throws IOException {
        Scanner file1 = new Scanner(new File("Langdats/prg404a1.dat"));
        Scanner file2 = new Scanner(new File("Langdats/prg404a2.dat"));

        ArrayList<Integer> nums = new ArrayList<>();
        while (file1.hasNextInt())nums.add(file1.nextInt());
        while (file2.hasNextInt())nums.add(file2.nextInt());

        List<Integer> pos = nums.stream().filter(n -> n>=0).toList();
        List<Integer> neg = nums.stream().filter(n -> n<0).toList();

        for (int lcv = 0; lcv < (Math.max(pos.size(), neg.size())); lcv++) {
            System.out.println(pos.get(lcv) + " " + neg.get(lcv)); // data files are the same # of ints
        }
    }
}
/*
3 -8
66 -16
54 -56
22 -34
19 -22
21 -55
34 -3
64 -55
55 -76
9 -45
39 -3
54 -66
33 -54
8 -22
10 -19
56 -21
34 -34
22 -64
55 -55
3 -9
55 -89
76 -54
45 -33

 */