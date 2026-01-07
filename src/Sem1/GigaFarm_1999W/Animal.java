package Sem1.GigaFarm_1999W;

public class Animal {
    protected int feedCount, feedCost, income, weight;
    public Animal() {
        this.feedCost = 0;
        this.income = 0;
    }
    public int getFeedCost() {return feedCost;}
    public int getIncome()   {return income;}
}
