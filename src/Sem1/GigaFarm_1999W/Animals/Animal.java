package Sem1.GigaFarm_1999W.Animals;

import java.util.HashMap;
import java.util.Map;

public class Animal {
    protected int feedCost, income, weight;
    protected Map<String, Integer> foods = new HashMap<>();
    public Animal() {
        this.feedCost = 0;
        this.income = 0;
    }
    public int getFeedCost() {return feedCost;}
    public int getIncome()   {return income;}
}
