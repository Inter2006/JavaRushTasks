package test;

public class Main {
    public static void main(String[] args){
        Animal animal = new Animal();
        // animal.sayHello();
        Cat cat = new Cat("Шотландская-вислаухая","Дуня",3 );
        // cat.sayHello();
        Animal myAnimal = cat;
        myAnimal.sayHello();
    }

}
