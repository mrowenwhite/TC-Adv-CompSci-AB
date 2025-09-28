package Generics_Test;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    public void speak() {
        System.out.println("Meow!");
    }
    public void print() {
        System.out.printf("%s\t%s\t%d\n", "Cat", this.getName(), this.getAge());
    }
}
