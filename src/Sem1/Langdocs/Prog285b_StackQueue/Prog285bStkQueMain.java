package Sem1.Langdocs.Prog285b_StackQueue;

import Sem1.Langdocs.Prog285b.Com;
import Sem1.Langdocs.Prog285b.Node;
import Sem1.Langdocs.Prog285b.Prog285bHelper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Prog285bStkQueMain {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdats/Prog285b.txt"));

        Stack<Com> stack = new Stack<>();
        Queue<Com> queue = new LinkedList<>();

        while (input.hasNext()) {
            Com com = new Com(input.nextInt(), input.nextInt(), input.nextInt());
            stack.push(com);
            queue.add(com);
        }

        stack.forEach(Com::calc);
        stack = stack.stream().filter(c -> c.getcommision() != 0).collect(Collectors.toCollection(Stack::new));
        stack.forEach(System.out::println);
        System.out.println("\n\n\n\n\n");


        queue.forEach(Com::calc);
        queue = queue.stream().filter(c -> c.getcommision() != 0).collect(Collectors.toCollection(LinkedList::new));
        queue.forEach(System.out::println);

        System.out.println("\n\n");




    }

}
