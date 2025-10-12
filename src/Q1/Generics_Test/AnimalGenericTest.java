package Q1.Generics_Test;


import java.util.*;
import java.io.*;

public class AnimalGenericTest {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("C:\\Users\\Owenw\\IdeaProjects\\TC-Advanced-Computer-Science-AB-Java\\src\\Generics_Test\\animals.txt"));
        ArrayList<Animal> animals =  new ArrayList<>();

        while (file.hasNext()) {
            if (file.nextInt()==1) animals.add(new Dog(file.next(), file.nextInt()));
            if (file.nextInt()==2) animals.add(new Cat(file.next(), file.nextInt()));
        }






    }
}
