package Q1.Langdocs.Prog285b;

import java.util.*;
import java.io.*;
import java.util.Iterator;

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

        Iterator<Com> coms = list.iterator();
        System.out.println("\n\n");

        while (coms.hasNext()) {
            Com cool = coms.next();
            System.out.println(cool);
        }

    }
}
