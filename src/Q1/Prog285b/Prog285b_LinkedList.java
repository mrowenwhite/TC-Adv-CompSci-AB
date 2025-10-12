package Q1.Prog285b;

import java.util.*;
import java.io.*;

public class Prog285b_LinkedList {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdats/Prog285b.txt"));;

        Prog285bHelper list = new Prog285bHelper();

        while (input.hasNext()) {
            list.addBack(new Node(new Com(input.nextInt(),input.nextInt(),input.nextDouble())));
        }


        list.calc();
        list.print();
        System.out.println("\n\n");
        list.deleteZeros();
        list.print();

        System.out.println("\n\n");


    }
}
