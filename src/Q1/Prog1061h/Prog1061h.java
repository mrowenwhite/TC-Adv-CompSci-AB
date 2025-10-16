package Q1.Prog1061h;


import java.io.*;
import java.util.*;

class Prog1061h {
    public static void main(String[] args) throws IOException {
        p1061Helper list = new p1061Helper();
        Scanner file = new Scanner(new File("Langdats/prg1061h.txt"));

        int cnt = 0;
        while (file.hasNextLine()) {
            list.addAlphabetically(file.nextLine());
        }
        list.print();
    }
}
