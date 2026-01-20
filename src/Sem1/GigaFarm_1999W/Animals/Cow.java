package Sem1.GigaFarm_1999W.Animals;

public class Cow extends Animal {
    private final int milk;
    public Cow() {
        super();
        this.weight = (int)((Math.random()*1500-1001)+1000);
        this.milk   = (int)((Math.random()*100-21)+20); // 20-100 gals milk
        this.foods.put("corn",     (int)((Math.random()*4-3)+2)); // 2-4 corn
        this.foods.put("haybales", (int)((Math.random()*3-2)+1)); //1-3 bales
        this.foods.put("beans",    (int)((Math.random()*5-3)+2)); // 2-5 beans
        this.foods.put("oats",     (int)((Math.random()*4-3)+2)); // 2-4 oats

    }
    public int getMilk() {return milk;}
    public int getWeight() {return weight;}



}
