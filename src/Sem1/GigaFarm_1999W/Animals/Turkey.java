package Sem1.GigaFarm_1999W.Animals;

public class Turkey extends Animal {
    private final double lbVal;
    public Turkey() {
        super();
        this.weight = (int)((Math.random()*35-26)+25);
        this.lbVal = (Math.random()*0.99-76)+0.75;

        this.foods.put("corn", (int)(Math.random()*3-2)+1); //1-3 corns
        this.foods.put("oats", (int)(Math.random()*4-3)+2); // 2-4 oats
    }
    public double getVal() {return lbVal;}
}
