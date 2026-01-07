package Sem1.GigaFarm_1999W.Animals;

import java.util.*;

public class Horse extends Animal{

    public Horse() {
        super();

    }
    public String makeName() {
        char[] letters = {'a','b','c','d','e','f','g', 'h','j','k','l','m','n','o','p', 'q','r','s','t','u','v','w','x', 'y','z'};
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        String name = "####";
        for (int i = 0; i < name.length(); i++) {
            char letter = letters[(int)(Math.random()*25-1)];
        }

    }
}
