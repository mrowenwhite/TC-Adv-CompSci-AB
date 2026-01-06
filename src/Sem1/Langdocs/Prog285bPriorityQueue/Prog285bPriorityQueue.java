package Sem1.Langdocs.Prog285bPriorityQueue;
import java.io.*;
import java.util.*;
public class Prog285bPriorityQueue {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/Prog285b.txt"));
        ArrayDeque<Com>[] pq = new ArrayDeque[20];
        for (int i=0;i<pq.length;i++){
            pq[i]=new ArrayDeque<>();
        }
        while (file.hasNext()) {
            Com com = new Com(file.nextInt(), file.nextInt(), file.nextDouble());
            pq[com.getCode()].add(com);
        }
        Arrays.stream(pq).forEach(x -> x.forEach(Com::calc));
        Arrays.stream(pq).forEach(x -> x.removeIf(com -> com.getcommision()==0));
        for (Queue<Com> q : pq)
            while(!q.isEmpty()) {
                Com com = q.poll();System.out.println(com);
            }
    }
}
/*
103	5	4000.0	290.0
125	5	6500.0	502.5
218	5	5000.0	375.0
235	5	5250.0	396.25
118	8	7350.0	574.75
192	8	8125.0	640.625
203	8	3250.0	243.75
101	17	2250.0	213.75
138	17	6375.0	550.625
264	17	4150.0	394.25
291	17	750.0	71.25

Process finished with exit code 0
 */