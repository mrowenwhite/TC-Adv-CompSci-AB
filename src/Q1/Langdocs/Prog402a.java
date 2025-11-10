package Q1.Langdocs;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Prog402a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner (new File("Langdats/prg402a.dat"));
        Map<Integer, Integer> map = new HashMap<>();
        while (file.hasNextInt()) {
            map.put(file.nextInt(), file.nextInt());
        }
        double avg = map.values().stream().mapToInt(i -> i).sum() / (double)map.size();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("ID: %d\tScore: %d\tResidual: %.2f\n", entry.getKey(), entry.getValue(), (entry.getValue()-avg));
        }
        System.out.println("\n\nAverage score: " + avg);

    }
}
/*
ID: 321	Score: 245	Residual: 2.38
ID: 323	Score: 245	Residual: 2.38
ID: 325	Score: 246	Residual: 3.38
ID: 104	Score: 239	Residual: -3.62
ID: 203	Score: 224	Residual: -18.62
ID: 301	Score: 242	Residual: -0.62
ID: 110	Score: 238	Residual: -4.62
ID: 207	Score: 228	Residual: -14.62
ID: 112	Score: 239	Residual: -3.62
ID: 208	Score: 242	Residual: -0.62
ID: 113	Score: 243	Residual: 0.38
ID: 305	Score: 265	Residual: 22.38
ID: 306	Score: 262	Residual: 19.38
ID: 115	Score: 257	Residual: 14.38
ID: 116	Score: 246	Residual: 3.38
ID: 213	Score: 229	Residual: -13.62
ID: 311	Score: 256	Residual: 13.38
ID: 218	Score: 243	Residual: 0.38
ID: 123	Score: 253	Residual: 10.38
ID: 222	Score: 223	Residual: -19.62
ID: 223	Score: 230	Residual: -12.62


Average score: 242.61904761904762

Process finished with exit code 0
 */
