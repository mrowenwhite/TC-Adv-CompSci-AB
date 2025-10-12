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
/*
ID	Code	Sales	Commission

101	17	213.75	2250.0	213.75
103	5	290.0	4000.0	290.0
117	3	0.0	7350.0	0.0
118	8	574.75	7350.0	574.75
125	5	502.5	6500.0	502.5
138	17	550.625	6375.0	550.625
192	8	640.625	8125.0	640.625
203	8	243.75	3250.0	243.75
218	5	375.0	5000.0	375.0
235	5	396.25	5250.0	396.25
264	17	394.25	4150.0	394.25
291	17	71.25	750.0	71.25



ID	Code	Sales	Commission

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
 */