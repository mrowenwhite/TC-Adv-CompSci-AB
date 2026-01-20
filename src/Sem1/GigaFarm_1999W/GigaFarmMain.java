package Sem1.GigaFarm_1999W;

import java.util.*;

public class GigaFarmMain {
    public static void main(String[] args) {
        LinkedList<Farm> farms = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            farms.add(new Farm());
        }

        //1 most profitable animal for each farm?
        for (int i = 0; i < farms.size(); i++) {
            System.out.println("Farm " + (i + 1) + ": " + farms.get(i).bestAnimal());
        }




    }
}
