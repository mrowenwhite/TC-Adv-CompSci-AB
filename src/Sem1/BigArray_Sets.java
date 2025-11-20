package Sem1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BigArray_Sets {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        while (set.size()<19) set.add(rand.nextInt(20, 90));
        //1
        Iterator<Integer> itr = set.iterator(); //create
        while (itr.hasNext()) System.out.print(itr.next() + " "); //print
        System.out.println(); // add a line break
        itr = set.iterator(); // reset
        //2
        for (Integer i : set) System.out.print(i + " ");
        System.out.println();
        //3
        int lcv = 0;
        while (lcv < set.size()/2) {
            itr.next();
            lcv++;
        }
        System.out.println(itr.next() + " is the middle value");
        itr = set.iterator();
        //4
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        for (Integer i : set) {
            if (i > largest) largest = i;
            if (i < smallest) smallest = i;
        }
        System.out.println("largest: " + largest + " smallest: " + smallest);
        // 5
        System.out.println(itr.next());
        System.out.println(itr.next());
    }
}
