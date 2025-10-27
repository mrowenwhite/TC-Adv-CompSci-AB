package Q1.Langdocs.Prog410t;

import java.util.*;
import java.io.*;

public class Prog410t {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(new File("Langdats/survey.dat"));

        ArrayList<Household> households = new ArrayList<>();
        while (f.hasNextInt()) {
            households.add(new Household(f.nextInt(), f.nextInt(), f.nextInt()));
        }
        f = new Scanner(new File("Langdats/survey2.dat"));
        while (f.hasNextInt()) {
            households.add(new Household(f.nextInt(), f.nextInt(), f.nextInt()));
        }


        int poverties = 0;
        int average = 0;
        for (Household hh : households) {
            if (hh.isBelowPovertyLine())
                poverties++;
            average+=hh.getIncome();
        }
        average/=households.size();

        for (Household hh : households)
            System.out.println(hh);

        System.out.printf("%.2f%% of households are below the poverty line", (double)poverties/households.size());

        System.out.printf("Households with above average (%d) income: \n", average);
        for (Household hh : households)
            if (hh.getIncome()>average)
                System.out.println(hh);
    }


}
/*
2497	12500	2
3323	13000	5
4521	18210	4
6789	8000	2
5476	6000	1
4423	16400	3
6587	25000	4
3221	10500	4
5555	15000	2
1085	19700	3
3097	20000	8
4480	23400	5
2065	19700	2
8901	13000	3
1041	12180	4
1062	13240	3
1327	19800	2
1483	22458	8
1900	17000	2
2112	18125	7
2345	15623	2
3210	3200	6
3600	6500	5
3601	11970	2
4725	8900	3
6217	10000	2
9280	6200	1
0.04% of households are below the poverty lineHouseholds with above average (14281) income:
4521	18210	4
4423	16400	3
6587	25000	4
5555	15000	2
1085	19700	3
3097	20000	8
4480	23400	5
2065	19700	2
1327	19800	2
1483	22458	8
1900	17000	2
2112	18125	7
2345	15623	2

Process finished with exit code 0
 */
