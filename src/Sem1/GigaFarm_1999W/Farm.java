package Sem1.GigaFarm_1999W;

import Sem1.GigaFarm_1999W.Animals.*;

import java.util.*;

public class Farm {
    int[][] riders = new int[3][7];
    HorseList         horseList = new HorseList();
    Pig[]             pigs      = new Pig[20];
    Set<Turkey>       turkeys   = new HashSet<>();
    Map<Integer, Cow> cows      = new HashMap<>();
    Map<String, Integer> foodStock = new HashMap<String, Integer>();

    public Farm() {
        foodStock.put("corn",     (int)(Math.random()*15000-9999)+10000);
        foodStock.put("haybales", (int)(Math.random()*3000-1999)+2000);
        foodStock.put("beans",    (int)(Math.random()*1000-749)+750);
        foodStock.put("oats",     (int)(Math.random()*2500-1699)+1700);
        //populate rider matrix
        for (int i = 0; i < riders.length; i++)
            for(int j = 0; j < riders[i].length; j++)
                riders[i][j] = (i==5) ? (int)(Math.random()*10-6)+5 : (i==6) ? (int)(Math.random()*7-4)+3 : (int)(Math.random()*5-2)+1;
    }
}
