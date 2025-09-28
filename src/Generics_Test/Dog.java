package Generics_Test;

public class Dog extends Animal{

    public Dog(String name, int age) {
        super(name, age);
    }

    public void speak() {
        System.out.println("Bark!");
    }
    public void print() {
        System.out.printf("%s\t%s\t%d\n", "Dog", this.getName(), this.getAge());
    }
}
