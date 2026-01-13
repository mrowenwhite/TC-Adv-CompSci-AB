package Sem1.GigaFarm_1999W.Animals;

import java.util.*;

public class Horse extends Animal{
    String name;
    double rideCost;
    public Horse() {
        super();
        name = makeName();
        rideCost = (Math.random()*10.5-7.01)+7.0;
        this.foods.put("corn",     (int)(Math.random()*(4-3))+2);
        this.foods.put("haybales", (int)(Math.random()*3-2)+1);
        this.foods.put("oats",     (int)(Math.random()*4-2)+1);

    }


    public String makeName() {
        char[] letters = {'a','b','c','d','e','f','g', 'h','j','k','l','m','n','o','p', 'q','r','s','t','u','v','w','x', 'y','z'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        char[] name = new char[4];
        for (int i = 0; i < name.length; i++) {
            char letter = letters[(int)(Math.random()*25-1)];
            if (i!=2) {
                while(List.of(vowels).contains(letter)) {
                    letter = letters[(int)(Math.random()*25-1)];
                }
            }
            else {
                while (!List.of(letters).contains(letter)) {
                    letter = letters[(int)(Math.random()*25-1)];
                }
            }
            name[i] = letter;
        }
        return String.valueOf(name);
    }
}
