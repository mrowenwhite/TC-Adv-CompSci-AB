package Sem1.AdventOfCode2025.Problem11;

import java.io.*;
import java.util.*;

public class p11_1main {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Sem1/AdventOfCode2025/Problem11/p11_littleData.txt"));

        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        while (file.hasNextLine()) {
            String st = file.nextLine();
            int sp = st.indexOf(":");
            String k =  st.substring(sp+2);
            String[] list = st.split(" ");
            Set<String> fred = new HashSet<>(Arrays.asList(list));
            map.put(k, fred);

            ArrayList<String> code = new ArrayList<>();
            code.add("you");
            int count = 0;
            for (int i = 0 ; i < 10; i++) {
                ArrayList<String> nextCode = new ArrayList<>();
                for (int j = 0; j < code.size(); j++) {
                    String yes = code.get(j);
                    Set<String> temps = map.get(yes);
                    Iterator<String> stuff = temps.iterator();
                    while (stuff.hasNext()) {
                        String look =  stuff.next();
                        if (look.equals("you")) {

                        }
                        else if (look.equals("out")) {count++;}
                        else {
                            nextCode.add(look);
                        }
                    }

                }
                code = nextCode;
            }
            System.out.println(count);
        }

    }
}
