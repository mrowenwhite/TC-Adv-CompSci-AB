package Sem1.Langdocs.Prog285b_StackQueue;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Prog285bStkQueMain {
    public static void main(String[] args) throws IOException {
        Scanner    input = new Scanner(new File("Langdats/Prog285b.txt"));
        Stack<Com> stack = new Stack<>();
        Queue<Com> queue = new ArrayDeque<>();

        while (input.hasNext()) {
            Com com = new Com(input.nextInt(), input.nextInt(), input.nextDouble());
            stack.push(com);queue.add(com);
        }
        stack.forEach(Com::calc);
        queue.forEach(Com::calc);
        stack = stack.stream().filter(c -> c.getcommision() != 0).collect(Collectors.toCollection(Stack::new));
        queue = queue.stream().filter(c -> c.getcommision() != 0).collect(Collectors.toCollection(ArrayDeque::new));
        while (!stack.isEmpty()) System.out.println(stack.pop());
        System.out.println("\n\n\n\n");
        while (!queue.isEmpty()) System.out.println(queue.poll());

    }

}
/*
291	17	71.25	750.0	71.25
264	17	394.25	4150.0	394.25
235	5	396.25	5250.0	396.25
218	5	375.0	5000.0	375.0
203	8	243.75	3250.0	243.75
192	8	640.625	8125.0	640.625
138	17	550.625	6375.0	550.625
125	5	502.5	6500.0	502.5
118	8	574.75	7350.0	574.75
103	5	290.0	4000.0	290.0
101	17	213.75	2250.0	213.75





101	17	213.75	2250.0	213.75
103	5	290.0	4000.0	290.0
118	8	574.75	7350.0	574.75
125	5	502.5	6500.0	502.5
138	17	550.625	6375.0	550.625
192	8	640.625	8125.0	640.625
203	8	243.75	3250.0	243.75
218	5	375.0	5000.0	375.0
235	5	396.25	5250.0	396.25
264	17	394.25	4150.0	394.25
291	17	71.25	750.0	71.25

Process finished with exit code 0
 */