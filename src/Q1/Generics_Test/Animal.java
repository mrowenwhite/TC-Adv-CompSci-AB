package Q1.Generics_Test;

public abstract class Animal {
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void speak();


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
    public abstract void print();
}
