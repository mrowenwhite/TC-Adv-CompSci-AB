package Q1.Langdocs.Prog285bMap;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog285bMap {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdats/Prog285b.txt"));
        Map<Integer, Com> map = new HashMap<>();
        while (input.hasNext()) {
            int Id = input.nextInt();
            map.put(Id, new Com(Id, input.nextInt(), input.nextDouble()));
        }
        Set<Integer> keys = map.keySet();
        Iterator<Integer> itr  = keys.iterator();
        while (itr.hasNext()) {
            Com com = map.get(itr.next());com.calc();
        }
        itr = keys.iterator();
        while (itr.hasNext()) {
            System.out.println(map.get(itr.next()));
        }
    }
}
