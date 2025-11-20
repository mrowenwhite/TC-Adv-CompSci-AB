package Sem1.Langdocs.Prog285bSet;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Prog258bSet {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdats/Prog285b.txt"));
        Set<Com> stuff = new HashSet<>();

        while (input.hasNext()) {
            stuff.add(new Com(input.nextInt(), input.nextInt(), input.nextDouble()));
        }

        Iterator<Com> things = stuff.iterator();

        while (things.hasNext()) {
            Com com = things.next();
            com.calc();
        }

        for (Com com : stuff) {
            System.out.println(com);
        }



    }
}
