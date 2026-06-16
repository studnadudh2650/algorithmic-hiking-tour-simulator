package th.rosenheim.oop;

public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getRole();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}