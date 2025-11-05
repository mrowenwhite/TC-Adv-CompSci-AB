import java.util.*;

public class fifityRandomNumbers {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() <= 50) {
            set.add(r.nextInt(1000));
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
