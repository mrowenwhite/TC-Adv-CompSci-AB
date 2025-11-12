package Q1.BluePelicanBookPrograms.CodeTalker;
import java.util.*;
import java.io.*;

public class CodeTalker {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        Scanner file = new Scanner(new File("src/Q1/BluePelicanBookPrograms/CodeTalker/CodeTalkerData.dat"));
        int cnt = Integer.parseInt(file.nextLine());
        for (int i = 0; i <= cnt; i++) {
            String line =  file.nextLine();
            System.out.println(line);
            //map.put(line.substring(0, line.indexOf('=')), line.substring(line.indexOf('=') + 1));
            String[] arr = line.split("=");
            System.out.println(arr.length);
             map.put(arr[0], arr[1]);
        }

        String[] words = file.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (words[i].equals(entry.getKey())) {
                    System.out.print(entry.getValue());
                }
            }
            System.out.println();
        }

    }


}
