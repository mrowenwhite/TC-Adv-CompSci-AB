package Q1.Prog1061h;


import java.io.*;
import java.util.*;

class Prog1061h {
    public static void main(String[] args) throws IOException {
        p1061Helper list = new p1061Helper();
        Scanner file = new Scanner(new File("Langdats/prg1061h.dat"));
        int counter = 0;
        while (file.hasNext()) {
            System.out.println(counter);
            counter++;
            list.addAlphabetically(file.nextLine());
            list.print();
        }
        System.out.println("\n\n");
        list.print();
    }
}
