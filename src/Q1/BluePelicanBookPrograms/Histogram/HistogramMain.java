package Q1.BluePelicanBookPrograms.Histogram;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class HistogramMain {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/Q1/BluePelicanBookPrograms/Histogram/HistogramData.dat"));
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(",");
            for (String s : split)
                map.put(s, map.getOrDefault(s, 0) + 1);

            for (String key : map.keySet())
                System.out.println(key + " : " + map.get(key));
        }
    }
}
