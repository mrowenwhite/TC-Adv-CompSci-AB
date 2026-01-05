package Sem1.Langdocs.Prog285bPriorityQueue;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Prog285bPriorityQueue {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdats/Prog285b.txt"));
        ArrayDeque<Com>[] pq = new ArrayDeque[20];
        for (int i = 0; i < pq.length; i++) {
            pq[i] = new ArrayDeque<>();
        }
        while (file.hasNext()) {
            Com com = new Com(file.nextInt(), file.nextInt(), file.nextDouble());
            pq[com.getCode()].add(com);
        }

        Arrays.stream(pq).forEach(x -> x.forEach(Com::calc));
        Arrays.stream(pq).forEach(x -> x.forEach(System.out::println)); // only if not 0 com
        for (Queue<Com> q : pq) {while (!q.isEmpty()) {Com com = q.poll();System.out.println(com);}}
    }
}
