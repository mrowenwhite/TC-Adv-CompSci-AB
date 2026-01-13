package Sem1.GigaFarm_1999W;

import Sem1.GigaFarm_1999W.Animals.*;

import java.util.HashMap;
import java.util.Map;

public class Farm {
    Horse[][] riders = new Horse[3][7];
    Map<String, Integer> foodStock = new HashMap<String, Integer>();

    public Farm() {
        foodStock.put("corn",     (int)(Math.random()*15000-9999)+10000);
        foodStock.put("haybales", (int)(Math.random()*3000-1999)+2000);
        foodStock.put("beans",    (int)(Math.random()*1000-749)+750);
        foodStock.put("oats",     (int)(Math.random()*2500-1699)+1700);

    }
}
