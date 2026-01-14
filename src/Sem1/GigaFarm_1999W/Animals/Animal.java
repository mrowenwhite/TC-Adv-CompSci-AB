package Sem1.GigaFarm_1999W.Animals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Animal {
    protected int income, weight;
    protected double feedCost;
    protected Map<String, Integer> foods = new HashMap<>();
    public Animal() {
        this.feedCost = 0.0;
        this.income = 0;
    }
    public double getFeedCost() {
        feedCost = (this.foods.get("haybales")*2.25)+ (this.foods.get("corn")*0.19)+ (this.foods.get("beans")*0.07)+ (this.foods.get("oats")*0.04);
        return feedCost;
    }
    public int getIncome()   {return income;}
    public double getProfit() {return (double)this.income - this.feedCost;}

}

