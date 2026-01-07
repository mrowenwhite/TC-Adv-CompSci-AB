package Sem1.GigaFarm_1999W;

public class Cow extends Animal {
    private final int code;
    public Cow(int code) {
        super();
        this.code = code;
        this.weight = (int)((Math.random()*1500-1001)+1000);
    }
    public int getCode() {return code;}
    public int getWeight() {return weight;}



}
