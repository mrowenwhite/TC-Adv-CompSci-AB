package Sem1.GigaFarm_1999W.Animals;

public class Pig extends Animal {

    public Pig() {
        this.weight = (int)(Math.random()*(300-251)+250);
        this.foods.put("corn", (int)(Math.random()*10-6)+5);
        this.foods.put("oats", (int)(Math.random()*20-11)+10);
        this.foods.put("beans",(int)(Math.random()*50-21)+20);
    }

    public double getValue() {
        return this.weight*(Math.random()*(2.75-2.24)+2.25);
    }
}